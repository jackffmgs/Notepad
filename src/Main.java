import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static HashMap<String, Integer> numberBook = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    protected static String regNumber = "(\\+\\d+|\\d+)";
    protected static String regName = "([а-яА-Я]+|[a-zA-Z]+)";

    public static void main(String[] args)
    {
        numberBook.put("Test", 123);
        for (;;)
        {
            System.out.println("Введите команду, нормер или имя в записной книжке");
            String userText = scanner.nextLine();
            if (userText.equals("LIST"))
            {
                printMap(numberBook);
                continue;
            }
            IsUserTextValid(userText);
        }
    }

    public static String IsUserTextValid(String userText)
    {
        if(userText.matches(regName))
        {
            if(numberBook.containsKey(userText))
            {
                System.out.println(userText + ": +" + numberBook.get(userText));
                return "ggg";
            }
            System.out.println("Введите номер телефона для неизвестного пользователя");
            return AddNewID(userText, scanner.nextLine());
        }
        if(userText.matches(regNumber))
        {
             for(String key: numberBook.keySet())
               {
                   if (numberBook.get(key).equals(Integer.parseInt(userText)))
                   {
                       System.out.println(key + ": +" + numberBook.get(key));
                       return "thats all";
                   }
                   else
                   {
                       System.out.println("Введите имя пользьзователя для сохранения в записной книжке");
                       return AddNewID(scanner.nextLine(), userText);
                   }
               }
        }
        return Errormessag();
    }

    public static String AddNewID (String userName, String userNumber)
    {
        if (userName.matches(regName) == false || userNumber.matches(regNumber) == false )
        {
            return Errormessag();
        }

        numberBook.put(userName, Integer.parseInt(userNumber.replace("\\+&&\\w", "")));
        return "ggg";
    }

    public static String Errormessag()
    {
        System.out.println("Error");
        return "error";
    }
    private static void printMap(Map<String, Integer> map)
    {
        for(String key: map.keySet())
        {
            System.out.println(key + ": +" + map.get(key));
        }
    }

}
