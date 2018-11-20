package autotest;

import org.netbeans.jemmy.*;
import org.netbeans.jemmy.operators.*;

public class VladimirTestGUI implements Scenario{
   public int runIt(Object param){
	   String test1 = "тест 1 не пройден";
	   String test2 = "тест 2 не пройден";
	   String test3 = "тест 3 не пройден";
	   String test4 = "тест 4 не пройден";
	   String test5 = "тест 5 не пройден";
	   String test6 = "тест 6 не пройден";
	   String test7 = "тест 7 не пройден";
	   try {
		   new ClassReference ("program.Calculator").startApplication();
		   JFrameOperator frame = new JFrameOperator("Депозитный калькулятор");
		   new QueueTool().waitEmpty(200);
		   JTextFieldOperator Amount = new JTextFieldOperator(frame);
		   Amount.setText("1000");
		   new QueueTool().waitEmpty(100);
		   if(Amount.getText() == null) {
			   System.out.println("в поле Сумма в рублях не работает ввод");   
		   }else test1 = "тест 1 пройден успешно";
		   JTextFieldOperator Rate = new JTextFieldOperator(frame, 1);
		   Rate.setText("10");
		   new QueueTool().waitEmpty(100);
		   if(Rate.getText() == null) {
			   System.out.println("в поле Ставка в % не работает ввод");
		   }else test2 = "тест 2 пройден успешно";
		   JTextFieldOperator dateOpen = new JTextFieldOperator(frame, 2);
		   dateOpen.setText("1 нояб. 2018 г.");
		   new QueueTool().waitEmpty(100);
		   if(dateOpen.getText() == null) {
			   System.out.println("Не работает ввод в поле Дата открытия");
		   }else test3 = "тест 3 пройден успешно";
		   JTextFieldOperator dateClosed = new JTextFieldOperator(frame, 3);
		   dateClosed.setText("1 дек. 2018 г.");
		   new QueueTool().waitEmpty(100);
		   if(dateClosed.getText() == null) {
			   System.out.println("Не работает ввод в поле Дата закрытия");
		   }else test4 = "тест 4 пройден успешно";
		   new QueueTool().waitEmpty(100);
		   JButtonOperator jb = new JButtonOperator(frame, "Рассчитать");
		   jb.push();
		   new QueueTool().waitEmpty(100);
		   JLabelOperator days = new JLabelOperator(frame,"30");
		   if(days.getText().contentEquals("30")) {
			   test5 = "тест 5 пройден успешно";
		   }else System.out.println("Неправильно рассчитан срок вклада");
		   JLabelOperator result = new JLabelOperator(frame, "1008");
		   if(result.getText().contentEquals("1008")){
			   test6= "тест 6 пройден успешно";
		   }else System.out.println("Неправильный результат по вкладу");
		   new QueueTool().waitEmpty(100);
		   JButtonOperator clear = new JButtonOperator(frame, "Очистить");
		   clear.push();
		   new QueueTool().waitEmpty(100);
		   if(Amount.getText().isEmpty() && Rate.getText().isEmpty() && dateOpen.getText().isEmpty() &&
			   dateClosed.getText().isEmpty()){
			   test7 = "тест 7 пройден успешно";
		   }else System.out.println("Не работает кнопка Очистить");		
		   new QueueTool().waitEmpty(100);
		   System.out.println(test1);
		   System.out.println(test2);
		   System.out.println(test3);
		   System.out.println(test4);
		   System.out.println(test5);
		   System.out.println(test6);
		   System.out.println(test7);
		   frame.close();
		   return 1;		   
	   }catch(Exception e) {
        e.printStackTrace();
	    System.out.println("ERROR_TEST_PASSED");
	    return 0;
       }
   }
   public static void main(String[] args)  {
	   String[] params = {"autotest.VladimirTestGUI"};
	   org.netbeans.jemmy.Test.main(params);	   
   }
}