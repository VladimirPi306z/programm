package autotest;

import org.netbeans.jemmy.*;
import org.netbeans.jemmy.operators.*;


public class AdelinaTestGUI implements Scenario{
   public int runIt (Object param) {
	   String result0 = "Тест 1 не пройден";
	   String result1 = "Тест 2 не пройден";
	   String result2 = "Тест 3 не пройден";
	   String result3 = "Тест 4 не пройден";
	   String result4 = "Тест 5 не пройден";
	   String result5 = "Тест 6 не пройден";
	   String result6 = "Тест 7 не пройден";
	   String result7 = "Тест 8 не пройден";
	   try {
		   new ClassReference ("program.Calculator").startApplication();
		   JFrameOperator frame = new JFrameOperator("Депозитный калькулятор");
		   new QueueTool().waitEmpty(200);
		   if(frame.getTitle().contentEquals("Депозитный калькулятор")) {
			   result0 = "Тест 1 успешно пройден";
		   }else{
			   System.out.println("Ошибка в названии формы");
		   }
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelAmount = new JLabelOperator(frame, "Сумма в рублях");
		   if(labelAmount.getText().contentEquals("Сумма в рублях")) {
			   result1 = "Тест 2 успешно пройден";
		   }else {
			   System.out.println("Ошибка, отсутствует метка суммы");
		   }
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelRate = new JLabelOperator(frame, "Ставка в %");
		   if(labelRate.getText().contentEquals("Ставка в %")) {
			   result2 = "Тест 3 успешно пройден";
		   }else {
			   System.out.println("Ошибка, отсутствует метка ставка в %");
		   }
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelDateOpen = new JLabelOperator(frame, "Дата открытия");
		   if(labelDateOpen.getText().contentEquals("Дата открытия")) {
			   result3 = "Тест 4 успешно пройден";
		   }else {
			   System.out.println("Ошибка, отсутствует метка дата открытия");
		   }
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelDateClosed = new JLabelOperator(frame, "Дата закрытия");
		   if(labelDateClosed.getText().contentEquals("Дата закрытия")) {
			   result4 = "Тест 5 успешно пройден";
		   }else {
			   System.out.println("Ошибка отстутствует метка дата закрытия");
		   }	
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelTermOfDeposit = new JLabelOperator(frame, "Срок вклада в днях:");
		   if(labelTermOfDeposit.getText().contentEquals("Срок вклада в днях:")){
			   result5 = "Тест 6 успешно пройден";
		   }else {
			   System.out.println("Ошибка, отсутствует метка срок вклада");
		   }
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelResult = new JLabelOperator(frame, "Общая прибыль с учётом % по вкладу:");
		   if(labelResult.getText().contentEquals("Общая прибыль с учётом % по вкладу:")){
			   result6 = "Тест 7 успешно пройден";
		   }else {
			   System.out.println("Ошибка, отсутствует метка общая прибыль");
		   }
		   new QueueTool().waitEmpty(100);
		   JButtonOperator buttonOpenDate = new JButtonOperator(frame, 0);
		   buttonOpenDate.push();
		   new QueueTool().waitEmpty(100);
		   JButtonOperator buttonOpenDay = new JButtonOperator(frame, "20");
		   buttonOpenDay.push();
		   new QueueTool().waitEmpty(100);
		   JButtonOperator openCalendar1 = new JButtonOperator(frame, 1);
		   openCalendar1.push();
		   new QueueTool().waitEmpty(100);
		   JButtonOperator buttonCloseDay = new JButtonOperator(frame, "1");
		   buttonCloseDay.push();
		   new QueueTool().waitEmpty(100);
		   JTextFieldOperator Amount = new JTextFieldOperator(frame);
		   Amount.setText("1");
		   new QueueTool().waitEmpty(100);
		   JTextFieldOperator Rate = new JTextFieldOperator(frame, 1);
		   Rate.setText("1");
		   new QueueTool().waitEmpty(100);
		   JButtonOperator jbResult = new JButtonOperator(frame, "Рассчитать");
		   jbResult.push();
		   new QueueTool().waitEmpty(100);
		   JLabelOperator labelResultMany = new JLabelOperator(frame, "Дата закрытия вклада должна быть больше даты открытия");
		   if(labelResultMany.getText().contentEquals("Дата закрытия вклада должна быть больше даты открытия")){
			   result7 = "Тест 8 успешно пройден";
		   }else {
			   System.out.println("Ошибка, отсутствует поле предупреждения");
		   }
		   new QueueTool().waitEmpty(100);
		   System.out.println(result0);
		   System.out.println(result1);
		   System.out.println(result2);
		   System.out.println(result3);
		   System.out.println(result4);
		   System.out.println(result5);
		   System.out.println(result6);
		   System.out.println(result7);
		   frame.close();
		   return 1;
	   }catch (Exception e) {
		   return 0;
	   }	   
   }
   public static void main(String[] args)  {
	   String[] params = {"autotest.AdelinaTestGUI"};
	   org.netbeans.jemmy.Test.main(params);	   
   }
}
