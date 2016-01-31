// NOTE: NOT A JAVA CODE, ONLY MEANT FOR CODE FORMAT
// KSM-controller
// Code for Arduino Leonardo Circuit board for K-shoot Mania controller

#define DELAY            5  // Delay per loop in ms

#include <Encoder.h> 
long oldPositionL  = -999;
long oldPositionR  = -999;
Encoder EncL(0, 1);
Encoder EncR(2, 3);
 
 boolean A_set = false;              
 boolean B_set = false;
 boolean C_set = false;              
 boolean D_set = false;
 
void setup()
{
  pinMode(4, INPUT_PULLUP);
  pinMode(A0, INPUT_PULLUP);
  pinMode(A1, INPUT_PULLUP);
  pinMode(A2, INPUT_PULLUP);
  pinMode(A3, INPUT_PULLUP);
  pinMode(A4, INPUT_PULLUP);
  pinMode(A5, INPUT_PULLUP);
  Keyboard.begin();
 
  Serial.begin(9600);
}
 
void loop() {
 
  if(digitalRead(4)==LOW){
    Keyboard.press('a');
  }
  if(digitalRead(4)==HIGH){
    Keyboard.release('a');
  }
  if(digitalRead(A0)==LOW){
    Keyboard.press('b');
  }
  if(digitalRead(A0)==HIGH){
    Keyboard.release('b');
  }
  if(digitalRead(A1)==LOW){
    Keyboard.press('c');
  }
  if(digitalRead(A1)==HIGH){
    Keyboard.release('c');
  }
  if(digitalRead(A2)==LOW){
    Keyboard.press('d');
  }
  if(digitalRead(A2)==HIGH){
    Keyboard.release('d');
  }
  if(digitalRead(A3)==LOW){
    Keyboard.press('i');
  }
  if(digitalRead(A3)==HIGH){
    Keyboard.release('i');
  }
  if(digitalRead(A4)==LOW){
    Keyboard.press('f');
  }
  if(digitalRead(A4)==HIGH){
    Keyboard.release('f');
  }
  if(digitalRead(A5)==LOW){
    Keyboard.press('g');
  }
  if(digitalRead(A5)==HIGH){
    Keyboard.release('g');
  }
  delay(DELAY);
  
  long newPositionL = EncL.read();
  long newPositionR = EncR.read();
 
  if (newPositionL != oldPositionL) {
    Mouse.move(newPositionL - oldPositionL, 0, 0);
    oldPositionL = newPositionL;
  }
 
  if (newPositionR != oldPositionR) {
    Mouse.move(0, newPositionR - oldPositionR, 0);
    oldPositionR = newPositionR;
  }
}
