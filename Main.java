import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;  
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;

public class Main{
    
    public static String emailValid(String email){
    String regex = "^[a-zA-Z0-9+_.-]{1,20}@\\w{2,20}.\\w{2,3}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher mathcer = pattern.matcher (email);
    if(mathcer.matches())
      return "Email is valid";
    else
      return "Email is NOT valid";
    }

    public static String nameSurname(String fullName){
        String regex = "^([A-Z][a-z]+)\\s*([A-Z][a-z]+)*\\s([A-Z][a-z]+)*$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(fullName);
        String lastName = "";
        while (matcher.find()) {
            for(int i = 1; i <= matcher.groupCount(); i++) {
               lastName = matcher.group(i);
            }
        }
        String lastStr = "Hello Ms. "+ lastName;
        return lastStr;
    }
     
    public static String afterDotSpace(String line){
      String regex ="^([A-Za-z\\s]*[!?.,;]+)([A-Za-z\\s]*[!?.,;]?)$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(line);
      String result = "";
      while (matcher.find()) {
        String sentenceOne = matcher.group(1);
        String sentenceTwo = matcher.group(2);
        result = sentenceOne+" "+sentenceTwo;     
      }
      return result; 
    }

    public static String rudeLanguageCheck(String rudeWord){
      int lengthOfStars = rudeWord.length()-2;
      String regex ="^([A-Za-z])([A-Za-z]*)([A-Za-z])$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(rudeWord);
      String result = "";
      while (matcher.find()) {
        String firstLetter = matcher.group(1);
        String lastLetter = matcher.group(3);
        String stars = "*";
        result = firstLetter + stars.repeat(lengthOfStars) + lastLetter;
      } 
      return result;
    }
    
    public static String wordCount(String text){
      String regex ="\\bthe\\b";
      Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
      Matcher matcher = pattern.matcher(text);

      int count = 0;
        while (matcher.find())
            count++;
      String result = "\"the\" "+count+" times found in that paragraph";
      return result;
    }
    
    //Selim

    public static String scammerDetect(String stringS) {
       String regex = "(z[1i!]r[@4a]{2}t[b8][@a4]nk[@a4]s[1i!])";
       final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(stringS);
       String finalStr = "Detected variants: \n";
       while (matcher.find()) {
           for (int i = 1; i <= matcher.groupCount(); i++) {
               finalStr = finalStr + matcher.group(i) + "\n" ;
           }
       }
       return finalStr;
   }

    public static String turkeyPhoneNumberDetector(String str) {
       final String regex = "^[^\\+90]*(\\+90?[\\s]?[0-9]{3}[\\s]?[0-9]{3}[\\s]?[0-9]{2}[\\s]?[0-9]{2}).*$";
      
       final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(str);
       String finalstr = "Phone number/s that has been found : \n";
       while (matcher.find()) {
          
           for (int i = 1; i <= matcher.groupCount(); i++) {
               finalstr = finalstr + ("Phone number " + i + ": " + matcher.group(i) + "\n");
           }
           
       }return finalstr;
   }
  
    public static String lineCropToFit(String str) {
       final String regex = "(\\b.{1,25})(?:\\s+|$|\\n|\\.)";
       final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(str);
       int counter = 1;
       String finalStr = "Line by Line cropped version : \n";
       while (matcher.find()) {
           finalStr = finalStr + ("line "+ counter +": " + matcher.group(0)+"\n");
           counter = counter + 1;
       }
       return finalStr; 
      }

      public static String tcknExtract(String str) {
       final String regex = "^.*([\\d]{11}).*$";
       final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(str);
      String finalStr = "TCKN's : \n";
       while (matcher.find()) {
           for (int i = 1; i <= matcher.groupCount(); i++) {
               finalStr = finalStr + ("TCKN " + i + ": " + matcher.group(i) + "\n");
           }
       } return finalStr;
   }

   public static String indentDeletor(String string) {
       final String regex = "^[\\s]*(.*?)[\\s]*$";
      
       final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
       final Matcher matcher = pattern.matcher(string);
      String finalStr = "";
       while (matcher.find()) {
         
           for (int i = 1; i <= matcher.groupCount(); i++) {
               finalStr = finalStr + matcher.group(i);
           }
       } return finalStr;
   }

    //Alperen

    public static String BuyukUnlu(String word){
    Pattern p1 = Pattern.compile("(.?)[a,ı,o,u]((.+)[a,ı,o,u])(.?)");
    Pattern p2 = Pattern.compile("(.?)[e,i,ö,ü]((.+)[e,i,ö,ü])(.?)");

    while(true){
      Matcher m1 = p1.matcher(word);
      Matcher m2 = p2.matcher(word);

      boolean b1 = m1.find();
      boolean b2 = m2.find();

      if(b1==true ||b2==true ){
        return "Kelime büyük ünlü uyumu kuralına uymaktadır!";}
      else{
        return "Kelime büyük ünlü uyumu kuralına uymamaktadır!";}
    }
     
  }
  

    public static String PluralCheck(String word){
    Pattern p = Pattern.compile("[a-z]{1,2}\\w[f]{2}[a-z]*");
    Matcher m = p.matcher(word);
    boolean b = m.find();
    if(b==true){return "Your word is in regular form.";}
    else{return "Your word is not in regular form";}
    }

    public static void main(String []args){
        String[] arr = new String[12];
        String str = "";
        int i = 0;
        try{
        FileInputStream fis = new FileInputStream("input.txt");
        Scanner sc=new Scanner(fis);    
        while(sc.hasNextLine()){ 
          str = sc.nextLine(); 
          arr[i] = str;
          i++;
          //System.out.println(sc.nextLine());     
        }  
        sc.close();  
        }  
        catch(IOException e){   
        e.printStackTrace();  
        }
        int arrayLength = arr.length;

        /*
        for (int j = 0; j < arrayLength; j++) {
          System.out.println(arr[j]);
        }*/
        
        //example 1
        String resultOne = emailValid(arr[0]);
        System.out.println(resultOne);
        //example 2 
        String resultTwo = nameSurname(arr[1]);
        System.out.println(resultTwo);
        //example 3
        String resultThree = afterDotSpace(arr[2]);
        System.out.println(resultThree);
        //example 4
        String resultFour = rudeLanguageCheck(arr[3]);
        System.out.println(resultFour);
        //example 5
        String resultFive = wordCount(arr[4]);
        System.out.println(resultFive);
        //exp 6
        String resultSix = scammerDetect(arr[5]);
        System.out.println(resultSix);
        //exp 7
        String resultSeven = turkeyPhoneNumberDetector(arr[6]);
        System.out.println(resultSeven);
        //exp 8
        String resultEight = lineCropToFit(arr[7]);
        System.out.println(resultEight);
        //exp 9
        String resultNine = tcknExtract(arr[8]);
        System.out.println(resultNine);
        //exp 10
        String resultTen = indentDeletor(arr[9]);
        System.out.println(resultTen);
                //exp 11
        String resultEleven = BuyukUnlu(arr[10]);
        System.out.println(resultEleven);
                //exp 12
        String resultTwelve = PluralCheck(arr[11]);
        System.out.println(resultTwelve);
                //exp 13
        
        /*
        String resultThirteen = lineCropToFit(arr[12]);
        System.out.println(resultThirteen);
                //exp 14
        String resultFourteen = tcknExtract(arr[13]);
        System.out.println(resultFourteen);
                //exp 15
        String resultFifteen = indentDeletor(arr[14]);
        System.out.println(resultFifteen);
        */
        try {
            //Whatever the file path is.
            File statText = new File("statsTest.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            
            w.write(resultOne+"\n\n");
            w.write(resultTwo+"\n\n");
            w.write(resultThree+"\n\n");
            w.write(resultFour+"\n\n");
            w.write(resultFive+"\n\n");
            
            w.write(resultSix+"\n\n");
            w.write(resultSeven+"\n\n");
            w.write(resultEight+"\n\n");
            w.write(resultNine+"\n\n");
            w.write(resultTen+"\n\n");
            
            w.write(resultEleven+"\n\n");
            w.write(resultTwelve+"\n\n");
            /*
            w.write(resultThirteen+"\n\n");
            w.write(resultFourteen+"\n\n");
            w.write(resultFifteen+"\n\n");
            */
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file txt");
        }

     }
}

