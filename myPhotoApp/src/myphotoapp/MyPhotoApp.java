package myphotoapp;

public class MyPhotoApp {
    public static void main(String[] args) {
        // Сохранение выбранного изображения в базу
        MySQL.putPhoto("Тестовое имя", "C:\\Users\\Public\\Pictures\\test.jpg");
    }
}
