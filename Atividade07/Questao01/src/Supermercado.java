public class Supermercado {

    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String toString(){
        return this.item;
    }

    public boolean equals(Object o) {
        Supermercado outro = (item)o;
        return this.item.equals(outro.item);

    }

}
