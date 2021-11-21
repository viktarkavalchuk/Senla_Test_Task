import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Exercise_5 {

    public static class Safe {
        private double volume;
        private double remainingVolume;
        private ArrayList<Item> itemsInSafe;

        public ArrayList<Item> getItemsInSafe() {
            return itemsInSafe;
        }
        public void setItemsInSafe(ArrayList<Item> itemsInSafe) {
            this.itemsInSafe = itemsInSafe;
        }



        public double getRemainingVolume() {
            return remainingVolume;
        }
        public void setRemainingVolume(double remainingVolume) {
            this.remainingVolume = remainingVolume;
        }


        public Safe(double volume) {
            this.volume = volume;
            this.remainingVolume = volume;
            this.itemsInSafe = new ArrayList<Item>();
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public void addItem(Item item){
            this.itemsInSafe.add(item);
        }

        @Override
        public String toString() {
            String str = "Объем сейфа: " + this.volume + " л, Сейф загружен на " + (this.volume - this.remainingVolume)/this.volume * 100 + " %\r\n";
            str += "Предметы внутри сейфа:\r\n";
            for(Item item : itemsInSafe){
                str += item.toString() + "\r\n";
            }
            return str;
        }
    }

    public static class Item {
        public String name;
        public double volume;
        public double price;
        public double pricePerVolume;

        public Item(String name, double volume, double price) {
            this.name = name;
            this.volume = volume;
            this.price = price;
            this.pricePerVolume = price/volume;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public double getVolume() {
            return volume;
        }
        public void setVolume(int volume) {
            this.volume = volume;
        }

        public double getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }

        public double getPricePerVolume() {
            return pricePerVolume;
        }

        public void setPricePerVolume(double pricePerVolume) {
            this.pricePerVolume = this.pricePerVolume;
        }

        @Override
        public String toString() {
            return "Имя: " + this.name + ", Объем: " + this.volume + " л, Стоимость: " + this.price + " BYN";
        }
    }

    public static void main(String[] args) throws Exception {

        Safe safe = new Safe(50);

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("item1", 10, 100));
        items.add(new Item("item2", 20, 210));
        items.add(new Item("item3", 30, 350));
        items.add(new Item("item4", 40, 10));

        System.out.println("Исходный набор предметов:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println();

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o2.getPricePerVolume() - o1.getPricePerVolume() < 0) return -1;
                else if (o2.getPricePerVolume() - o1.getPricePerVolume() < 0) return 1;
                else return 0;
            }
        });
        
        for (Item item : items) {
            if (safe.getRemainingVolume() > item.volume){
                safe.setRemainingVolume(safe.getRemainingVolume()-item.volume);
                safe.addItem(item);
            }
        }
        System.out.println(safe.toString());
    }
}
