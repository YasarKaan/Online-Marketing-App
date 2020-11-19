package Shopping;

public interface IInventory<T>   {
    void addElementToInventory(T t,int in);
    boolean removeElementFromInventory(T t,int in);
}
