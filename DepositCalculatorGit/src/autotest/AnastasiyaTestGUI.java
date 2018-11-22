package autotest;

import org.netbeans.jemmy.*;
import org.netbeans.jemmy.operators.*;

public class AnastasiyaTestGUI implements Scenario{
   public int runIt(Object param) {
	   try {
	      new ClassReference ("program.Calculator").startApplication();
	      JFrameOperator frame = new JFrameOperator("Депозитный калькулятор");
	      new QueueTool().waitEmpty(200);  
	      JButtonOperator buttonOpenDate = new JButtonOperator(frame, 0);
	      buttonOpenDate.push();
	      new QueueTool().waitEmpty(100);
	      JButtonOperator openCalendar = new JButtonOperator(frame, 2);
	      openCalendar.push();
	      new QueueTool().waitEmpty(100);
	      JComboBoxOperator monthOpen = new JComboBoxOperator(frame);
          monthOpen.selectItem("января");       	  
          new QueueTool().waitEmpty(100);
	      JButtonOperator buttonOpenDay = new JButtonOperator(frame, "1");
	      buttonOpenDay.push();
	      new QueueTool().waitEmpty(100);
	      JButtonOperator openCalendar1 = new JButtonOperator(frame, 1);
	      openCalendar1.push();
	      new QueueTool().waitEmpty(100);
	      JButtonOperator jbb = new JButtonOperator(frame, 3);
	      jbb.push();
	      JComboBoxOperator monthClosed = new JComboBoxOperator(frame);
	      monthClosed.selectItem("декабря");
	      new QueueTool().waitEmpty(100);
	      JButtonOperator buttonCloseDay = new JButtonOperator(frame, "31");
	      buttonCloseDay.push();
	      new QueueTool().waitEmpty(100);
	      JTextFieldOperator Amount = new JTextFieldOperator(frame);
		  Amount.setText("10000");
		  new QueueTool().waitEmpty(100);
		  JTextFieldOperator Rate = new JTextFieldOperator(frame, 1);
		  Rate.setText("5");
		  new QueueTool().waitEmpty(100);
	      JButtonOperator jb = new JButtonOperator(frame, "Рассчитать");
		  jb.push();
		  new QueueTool().waitEmpty(100);
	      JLabelOperator jl = new JLabelOperator(frame, "729");
	      if(jl.getText().contentEquals("729")) {
	    	  System.out.println("Тест успешно завершен");
	      }else {
	    	  System.out.println("Тест не пройден");
	      }
	      frame.close();
	      return 1;
	   }catch(Exception e){
		   e.printStackTrace();
		    System.out.println("ERROR_TEST_PASSED");
		    return 0;
	   }
   }
   public static void main(String[] args)  {
	   String[] params = {"autotest.AnastasiyaTestGUI"};
	   org.netbeans.jemmy.Test.main(params);	   
   }
}
