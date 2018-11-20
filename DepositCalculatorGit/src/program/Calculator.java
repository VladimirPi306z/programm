package program;

import com.toedter.calendar.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.text.*;
import java.util.Date;

public class Calculator{
      Calculator(){ 
      JFrame jfrm = new JFrame("Депозитный калькулятор");
      //jfrm.setLocationRelativeTo(null);
      jfrm.setLayout(null);
      jfrm.setSize(600, 300);//размер фрейма
      jfrm.setResizable(false);//запрет изменения размера окна
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//действие при закрытии окна
      
      //определение объектов текстовых полей
  	  JLabel textAmount = new JLabel("Сумма в рублях");
  	  JLabel textRate = new JLabel("Ставка в %");
  	  JLabel textOpeningDate = new JLabel("Дата открытия");
  	  JLabel textCloseDate = new JLabel("Дата закрытия");
  	  JLabel textTimeInDays = new JLabel("Срок вклада в днях:");
  	  JLabel textResult = new JLabel("Общая прибыль с учётом % по вкладу:");
  	  JLabel textResultInDays = new JLabel();//+
  	  JLabel textResultDeposit = new JLabel();
  	  JLabel textErrorDate = new JLabel("");
  	  
  	  //определение объектов ввода
      JTextField fieldAmount = new JTextField();
      JTextField fieldRate = new JTextField();
      
      //определение объектов даты
      JDateChooser dateOne = new JDateChooser();
      JDateChooser dateTwo = new JDateChooser();
      
      //определение объектов кнопок
      JButton calculate = new JButton("Рассчитать");
      JButton clear = new JButton("Очистить");
      
      //определение положения элементов
      textAmount.setLocation(10, 20);
      textRate.setLocation(350, 20);
      textOpeningDate.setLocation(10, 50);
      textCloseDate.setLocation(325, 50);
      textErrorDate.setLocation(10, 80);
      textTimeInDays.setLocation(10, 150);
      textResultInDays.setLocation(135, 150);//+
      textResult.setLocation(10, 180);
      textResultDeposit.setLocation(240, 180);
      fieldAmount.setLocation(110, 20);
      fieldRate.setLocation(420, 20);
      dateOne.setLocation(110, 51);
      dateTwo.setLocation(420, 51);
      calculate.setLocation(200, 110);
      clear.setLocation(450, 220);
      
      //определение размера элементов
      textAmount.setSize(100, 30);
      textRate.setSize(100, 30);
      textOpeningDate.setSize(120, 30);
      textCloseDate.setSize(100, 30);
      textErrorDate.setSize(600, 30);
      textTimeInDays.setSize(120, 30);//--
      textResultInDays.setSize(200, 30);
      textResult.setSize(230, 30);
      textResultDeposit.setSize(335, 30);
      fieldAmount.setSize(150, 30);
      fieldRate.setSize(150, 30);
      dateOne.setSize(150, 30);
      dateTwo.setSize(150, 30);
      calculate.setSize(200, 30);
      clear.setSize(120, 30);
      
      //обработка ввода в поле "сумма в рублях"
      PlainDocument doc = new PlainDocument();
      doc.setDocumentFilter(new DocumentFilter() {
          public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
        		  throws BadLocationException {
              if (checkString(string)){
                  super.insertString(fb, offset, string, attr);
              }
          }

          public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
        		  throws BadLocationException {
              if (checkString(text)){
                  super.replace(fb, offset, length, text, attrs);
              }
          }
          private boolean checkString(String text){
              if (text!=null){
                  for(int i=0; i<text.length(); i++){
                      if (!Character.isDigit(text.charAt(i))){
                          return false;
                      }
                  }
              }
              return true;
          }
      });
      
      //обработка ввода в поле "ставка %"
      PlainDocument doc1 = new PlainDocument();
      doc1.setDocumentFilter(new DocumentFilter() {
          public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) 
        		  throws BadLocationException {
              if (checkString(string)){
                  super.insertString(fb, offset, string, attr);
              }
          }

          public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
        		  throws BadLocationException {
              if (checkString(text)){
                  super.replace(fb, offset, length, text, attrs);
              }
          }
          private boolean checkString(String text){
              if (text!=null){
                  for(int i=0; i<text.length(); i++){
                      if (!Character.isDigit(text.charAt(i))){
                          return false;
                      }
                  }
              }
              return true;
          }
      });

      fieldAmount.setDocument(doc);
      fieldRate.setDocument(doc1);
     
      //обработка события нажатия кнопки "Рассчитать"
      calculate.addActionListener(new ActionListener() {//старый способ
    	  public void actionPerformed(ActionEvent  ae) {  
    		  try {
    			textResultInDays.setText("");
    			textResultDeposit.setText("");
    		    int amount = Integer.parseInt(fieldAmount.getText());
    		    int rate = Integer.parseInt(fieldRate.getText());
    		    Date datOne = dateOne.getDate();
    		    Date datTwo = dateTwo.getDate();
    		    String strDateOne = DateFormat.getDateInstance().format(datOne);                
                String strDateTwo = DateFormat.getDateInstance().format(datTwo);
                String splittDateOne = Splitter(strDateOne);
                String splittDateTwo = Splitter(strDateTwo);             
                int Days = DateProcess(splittDateOne, splittDateTwo);
                if(Days == -1 ) {
                	textErrorDate.setText("Дата закрытия вклада должна быть больше даты открытия");
                }else {
                  textErrorDate.setText("");
                  int Result = Handler(rate, amount, Days);
                  String strDays = String.valueOf(Days);
                  String strResulting = String.valueOf(Result);
                  textResultInDays.setText(strDays);
                  textResultDeposit.setText(strResulting);
                }
    		  }catch(Exception e){
    			//
              } 		  
    	  }
      });
      
      //обработка события нажатия кнопки "Очистить"
      clear.addActionListener(new ActionListener() {//старый способ
    	  public void actionPerformed(ActionEvent  ae) {
    		    fieldAmount.setText(null);
    		    fieldRate.setText(null);
    		    dateOne.setDate(null);
    		    dateTwo.setDate(null);
    		    textResultInDays.setText(null);
    		    textResultDeposit.setText(null);
    	  }
      });

      //добавление элементов во фрейм
      jfrm.add(textAmount);
      jfrm.add(textRate);
      jfrm.add(textOpeningDate);
      jfrm.add(textCloseDate);
      jfrm.add(textErrorDate);
      jfrm.add(textTimeInDays);
      jfrm.add(textResultInDays);//+
      jfrm.add(textResult);
      jfrm.add(textResultDeposit);
      jfrm.add(fieldAmount);
      jfrm.add(fieldRate);
      jfrm.add(calculate);
      jfrm.add(dateOne);
      jfrm.add(dateTwo);
      jfrm.add(calculate);
      jfrm.add(clear);	 
      
      //устанавливаем видимость элементов фрейма
      jfrm.setVisible(true);
     }
      
      //преобразовывает строку к формату dd.mm.yyyy
     public String Splitter(String strDate) {
    	  String[] arrDate;
    	  String delimeter = "\\ ";
    	  arrDate = strDate.split(delimeter);
    	  String month = arrDate[1];
    	  String numMonth;
    	  switch (month){
    		 case "янв." :
    			numMonth = "01";
    			break;
    		 case "февр." :
    			numMonth = "02";
    			break;
    		 case "мар." :
    			numMonth = "03";
    			break;
    		 case "апр." :
    			numMonth = "04";
    			break;
    		 case "мая"  :
    			numMonth = "05";
    			break;
    		 case "июн." :
    			numMonth = "06";
    			break;
    		 case "июл." :
    			numMonth = "07";
    			break;
    		 case "авг." :
    			numMonth = "08";
    			break;
    		 case "сент." :
    			 numMonth = "09";
    			 break;
    		 case "окт." :
    			 numMonth = "10";
    			 break;
    		 case "нояб." :
    			 numMonth = "11";
    			 break;
    		 case "дек." :
    			 numMonth = "12";
    			 break;
    		 default :
    			 numMonth = null;   	
    	  }
    	  strDate = arrDate[0] + "." + numMonth + "." + arrDate[2];
    	  return strDate;    	  
      }
      
     //рассчитываем колличество дней между датами
     public int DateProcess(String splittDateOne, String splittDateTwo ) {
    	  SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy"); 
	      Date dateOne = null;
	      Date dateTwo = null;
	      try {
	          dateOne = format.parse(splittDateTwo);
	          dateTwo = format.parse(splittDateOne);
	      } catch (Exception e) {
	          e.printStackTrace();
	      }	 
	      if(dateOne.getTime() > dateTwo.getTime()) {
	      // Количество дней между датами в миллисекундах
	      long difference = dateOne.getTime() - dateTwo.getTime();
	      // Перевод количества дней между датами из миллисекунд в дни
	      int days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
	      // Вывод разницы между датами в днях на экран
	     // System.out.println(days + " дн.");
	      return days;
	      }else {
	    	  return -1;
	      }
      }
     
     //подсчет итоговой суммы с учётом процентов
     public int Handler(int rate, int amount, int Days) {
    	 double r = (double)rate;
    	 double a = (double)amount;
    	 double D = (double)Days;
    	 double res = r / 36500 * a * D + a;
    	 int result = (int)res;
    	 return result;    	 
     }
    
    //точка входа программы
	public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  SwingUtilities.invokeLater(new Runnable() {
		  public void run() {
		  new Calculator();
		  }
	  });

	}
    /**
     * Method for starting SwingApplication
     */
	public static void startApp(){
		  SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		      new Calculator();
		    }
		  });
		}
}