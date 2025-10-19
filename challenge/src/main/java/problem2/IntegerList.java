package problem2;

public class IntegerList
{
    private int[] list; //values in the list // make it private
    private int listSize; // the number of elements currently in the list
    //-------------------------------------------------------
//create a list of the given size
//-------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
    }
    //-------------------------------------------------------
//fill array with integers between 1 and 100, inclusive
//-------------------------------------------------------
    public void randomize()
    {
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * 100) + 1;
        listSize = list.length;
    }
    //-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------
    public void print()
    {
        for (int i=0; i<listSize; i++)
            System.out.println(i + ":\t" + list[i]);
    }

    //-------------------------------------------------------
// Double the array size when it becomes full
//-------------------------------------------------------
    private void increaseSize() {
        int[] newList = new int[list.length * 2];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    //-------------------------------------------------------
// Add a new integer to the list
//-------------------------------------------------------
    public void addElement(int newValue) {
        if (listSize == list.length) {
            increaseSize();
        }
        list[listSize++] = newValue;
    }

    //-------------------------------------------------------
// Remove the first occurrence of the given value
// Returns true if a value was removed
//-------------------------------------------------------
    public boolean removeFirst(int value) {
        int indexToRemove = -1;

        for (int i = 0; i < listSize; i++) {
            if (list[i] == value) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            return false;
        }

        // Shift elements left
        for (int i = indexToRemove; i < listSize - 1; i++) {
            list[i] = list[i + 1];
        }

        listSize--;
        return true;
    }

    //-------------------------------------------------------
    // Remove all occurrences of the given value
    //-------------------------------------------------------
    public void removeAll(int value) {
        while (removeFirst(value)) {
            // keep removing until none left
        }
    }
}