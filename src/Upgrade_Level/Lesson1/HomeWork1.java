package Upgrade_Level.Lesson1;

/*
Создайте абстрактный класс с именем Metal, создайте и унаследуйте от него такие материалы
как steel, copper, iron.
В классе Metal нужен метод getEndurance, реализуйте его так, чтобы в классе steel
этот метод возвращал значение 50, в iron – 30, а в copper 20.
Создайте так же класс Plastic который не является подклассом класса Metal.
Создайте класс Sword, используя дженерики обеспечьте типобезопасность таким образом,
чтобы меч можно было создать используя любой материал, кроме пластика(Plastic).
В классе Sword создайте метод, который возвращает true, если меч прошёл проверку прочности
и false, если не прошёл. Используйте метод getEndurance.

Чтобы меч прошёл проверку прочности его прочность должна быть строго больше 49.
В классе Test создайте метод main и протестируйте ваше решение.
- У вас не должно получиться создать экземпляр меча используя пластик.
- Создайте меч используя steel
- Выведите на экран прошёл ли меч проверку прочности.

 */
public class HomeWork1 {
    public static abstract class Metal{
        abstract int getEndurance();
    }
    public static class Steel extends Metal{
        public int getEndurance(){
            int endurance = 50;
            return endurance;
        }
    }
    public static class Copper extends Metal{
        public int getEndurance(){
            int endurance = 20;
            return endurance;
        }
    }
    public static class Iron extends Metal{
        public int getEndurance(){
            int endurance = 30;
            return endurance;
        }
    }
    public class Plastic{}

    public static class Sword<T extends Metal>{
        private T material;

        public Sword(T material){
            this.material = material;
        }
        public boolean checkStrength(){
            if(material.getEndurance() > 49){
                return true;
            }else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        //Sword<Plastic> newSword = new Sword(); - не получилось создать меч из пластика
        Sword steelSword = new Sword(new Steel());
        System.out.println(steelSword.checkStrength());//true
    }
}
