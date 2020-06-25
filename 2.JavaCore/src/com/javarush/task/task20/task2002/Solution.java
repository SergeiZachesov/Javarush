package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //1.Создание временного файла
            File yourFile = File.createTempFile("your_file_name", null, new File("C:\\Users\\Сергей\\YandexDisk\\Программирование\\Java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002"));

            //2.Создания потока вывода и ввода байтов
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            //3.Создание объекта javaRush
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            //4. Создание юзера для джавы раши
            User user1 = new User();

            //5. Добавление параметров для
            user1.setBirthDate(null);
            user1.setCountry(User.Country.UKRAINE);
            user1.setFirstName("Vasy");
            user1.setLastName("Беде");
            user1.setMale(true);

            //6. Добавление в список юзеров
            javaRush.users.add(user1);

            //7. Сохранение в файл объекта джавы раша и финализирует состояние потока
            javaRush.save(outputStream);
            outputStream.flush();

            //8. Создает новый объект джавы раша
            JavaRush loadedObject = new JavaRush();

            //9. Загрузить объек джавы раша из файла
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            //10. Сранвнение объектов выгруженного и загруженного
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        //3.1 Создание списка пустого списка из юзеров
        public List<User> users = new ArrayList<>();


        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //6.1 Создание объекта вывода информации
            PrintWriter writer = new PrintWriter(outputStream);

            //6.2 Если юзеров нет, то писать что нет
            writer.println(this.users.size() > 0 ? "yes" : "no");

            //6.3 Если юзеры есть, то начать перебор юзеров и запись их данных в файл
            if (!(users.isEmpty())) {
                for (User a : users) {
                    writer.println(a.getFirstName());
                    writer.println(a.getLastName());
                    if (a.getBirthDate() == null) {
                        writer.println("null");
                    } else {
                        writer.println(a.getBirthDate().getTime());
                    }
                    writer.println(a.isMale());
                    writer.println(a.getCountry());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String isListPresent = br.readLine();

            if (isListPresent.equals("yes")) {
                while (br.ready()) {
                    User user = new User();
                    String firstName;
                    if ((firstName = br.readLine()) != null)
                        user.setFirstName(firstName);
                    else
                        user.setFirstName(null);

                    String lastName;
                    if ((lastName = br.readLine()) != null)
                        user.setLastName(lastName);
                    else
                        user.setLastName(null);

                    String date;
                    if ((date = br.readLine()) != null && !(date.equals("null")))
                        user.setBirthDate(new Date(Long.parseLong(date)));
                    else
                        user.setBirthDate(null);

                    String isMail = br.readLine();
                    if (isMail.equals("true")) {
                        user.setMale(true);
                    } else if (isMail.equals("false")) {
                        user.setMale(false);
                    }

                    String country = br.readLine();
                    switch (country) {
                        case "UKRAINE":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "RUSSIA":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "OTHER":
                            user.setCountry(User.Country.OTHER);
                            break;
                    }

                    users.add(user);
                }
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
