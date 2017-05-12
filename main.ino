
#include <SoftwareSerial.h>
#include<LiquidCrystal.h>
#include <Servo.h> 
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
SoftwareSerial mySerial(9, 10);

int motorPin1 = 8;
Servo myservo;
int pos = 0;
//int myservo = 13;

int sensor1=A1;
int sensor2=7;
float sensor3=A0;
float gas_value;
int sensor_value;
float temp_read,Temp_alert_val,Temp_shut_val;
//int sms_count1=0;
//int sms_count2=0;
//int sms_count3=0;
int ledpin1 = A4;
int ledpin2 = A3;
int ledpin3 = A2;


void setup()
{
   pinMode(motorPin1, OUTPUT);
  // pinMode(myservo, OUTPUT);
   myservo.attach(13);
  pinMode(sensor1,INPUT);
  pinMode(sensor2,INPUT);
  pinMode(sensor3,INPUT);
  pinMode(ledpin1,OUTPUT);
  pinMode(ledpin2,OUTPUT);
  pinMode(ledpin3,OUTPUT);
  lcd.begin(16, 2); 
  mySerial.begin(9600);   
  Serial.begin(9600);    
 
}

void loop()
{
  servo_dc_motor();
  CheckFire();
  CheckShutDown();
  CheckMotion();
  CheckSmoke();

}

void servo_dc_motor()
{
   if (Serial.available() > 0) {
     
   char data;
    data = Serial.read(); 

    switch(data)
    { 
       case '0':

      // digitalWrite(myservo, HIGH);
      
      for(; pos < 120; pos += 1)
      {
     myservo.write(pos);
              
     delay(20);    
      }
      lcd.setCursor(0,1);           
       lcd.print("LOCK CLOSE"); 
 
      break;
      
    case '1':

   // digitalWrite(myservo, LOW );
   
   
    for(; pos>=1; pos-=1)    
  {                                
    myservo.write(pos); 
             
    delay(20);                 
  }    
   lcd.setCursor(0,1);           
    lcd.print("LOCK  OPEN"); 
   
    break; 
      
      case '2':
    
     digitalWrite(motorPin1, HIGH);
     lcd.setCursor(0,1);           
     lcd.print("FAN  ON !!"); 

        
      break;
      
    case '3':
    
  digitalWrite(motorPin1, LOW);
  lcd.setCursor(0,1);           
   lcd.print("FAN OFF !!"); 

    break;
  }
}
}

void CheckFire()
{

Temp_alert_val=CheckTemp();
Serial.println(Temp_alert_val);
delay(2000);
if(Temp_alert_val>45)
{
   digitalWrite(ledpin1,HIGH);
   lcd.setCursor(0,0);  
   lcd.print("FIRE IN ROOM!!!"); 

   delay(2000);
   SetAlert(); 
}
else{
   digitalWrite(ledpin1,LOW);
  
}
}

float CheckTemp()
{
temp_read=analogRead(sensor1); 
temp_read=temp_read*5;    
temp_read=temp_read/10;
return temp_read;
}

void SetAlert()
{
//while(sms_count1<1) 
//{  
SendTextMessage1();
//}

}

void CheckShutDown()
{

Temp_shut_val=CheckTemp();
if(Temp_shut_val<18)
{
  SendTextMessage12();

}
}

void CheckMotion()
{
sensor_value=digitalRead(sensor2);
Serial.println(sensor_value);
delay(2000);
if(sensor_value==HIGH)
{
   digitalWrite(ledpin2,HIGH);
   lcd.setCursor(0,0);           
    lcd.print("MOTION DETECTED"); 

   delay(1000);
   SendTextMessage2();
}
  
 else
{
  digitalWrite(ledpin2,LOW);
}
}
void CheckSmoke()
{

gas_value=analogRead(sensor3);
Serial.println(gas_value);
delay(2000);
if(gas_value>500)
{
  digitalWrite(ledpin3,HIGH);
  lcd.setCursor(0,0);           
    lcd.print("SMOKE IN ROOM!!"); 

  delay(2000);
  SendTextMessage3();
}
else{
  digitalWrite(ledpin3,LOW);
}
}
  

void SendTextMessage1()
{
  mySerial.println("AT+CMGF=1");   
  delay(1000);
  mySerial.println("AT+CMGS=\"+917014893710\"\r"); 
  delay(1000);
  mySerial.println("Fire in NEW ROOM!");
  delay(100);
  mySerial.println((char)26);
  delay(1000);
  /* mySerial.println("AT+CMGS=\"+919794765991\"\r"); 
  delay(2000);
  mySerial.println("Fire in NEW ROOM!");
  delay(200);
  mySerial.println((char)26);
  delay(5000);
  sms_count1++;*/

}
void SendTextMessage12()
{
  mySerial.println("AT+CMGF=1"); 
  delay(1000);
  mySerial.println("AT+CMGS=\"+917014893710\"\r"); 
  delay(1000);
  mySerial.println("Now Everything is Safe!");
  delay(100);
  mySerial.println((char)26);
  delay(1000);
}

void SendTextMessage2()
{
   mySerial.println("AT+CMGF=1"); 
  delay(1000);
  mySerial.println("AT+CMGS=\"+917014893710\"\r"); 
  delay(1000);
  mySerial.println("PIR Detected a Motion in the Room!");
  delay(100);
  mySerial.println((char)26);
  delay(1000);
}

void SendTextMessage3()
{
   mySerial.println("AT+CMGF=1"); 
  delay(1000);
  mySerial.println("AT+CMGS=\"+917014893710\"\r"); 
  delay(1000);
  mySerial.println("Smoke in the Room!");
  delay(100);
  mySerial.println((char)26);
  delay(1000);
}

