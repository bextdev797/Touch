package com.bextdev.touch;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.view.View;
import android.view.MotionEvent;

public class Touch extends AndroidNonvisibleComponent {

  public Touch(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction
  public void ApplyTouchToComponent(AndroidViewComponent component) {
    View view = component.getView();
    view.setOnTouchListener(new View.OnTouchListener() {
     @Override
     public boolean onTouch(View v, MotionEvent me){
       if(me.getAction() == MotionEvent.ACTION_DOWN){
        TouchDown();
       } else if(me.getAction() == MotionEvent.ACTION_UP || me.getAction() == MotionEvent.ACTION_CANCEL) {
        TouchUp();
       } else if(me.getAction() == MotionEvent.ACTION_MOVE) {
        float x = me.getX();
        float y = me.getY();
        TouchMove(x, y);
      }
      return true;
     }
    });
  }
 
  @SimpleEvent
  public void TouchDown(){
   EventDispatcher.dispatchEvent(this, "TouchDown");
  }
 
  @SimpleEvent
  public void TouchUp(){
   EventDispatcher.dispatchEvent(this, "TouchUp");
  }

  @SimpleEvent
  public void TouchMove(float x, float y){
   EventDispatcher.dispatchEvent(this, "TouchMove", x, y);
  }
}