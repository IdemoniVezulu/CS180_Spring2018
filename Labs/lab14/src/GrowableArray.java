/**
 * A growable array that resizes itself as needed.
 *
 * <p>CS18000 -- Spring 2018 -- Dynamic Data Structures -- Lab</p>
 *
 * @author 
 * @version April DD, 2018
 * @param <T> the type of the values of this growable array
 */
public final class GrowableArray<T>
{
    /**
     * The values of this growable array.
     */
    private Object[] values;

    /**
     * The size of this growable array. The size is equal to the number of elements successfully added minus the
     * number of elements successfully removed.
     */
    private int size;

    /**
     * Constructs a newly allocated {@code GrowableArray} object with an initial capacity of ten.
     */
    public GrowableArray()
    {
        values = new Object[10];
        size = 0;
    } //GrowableArray

    /**
     * Adds the specified value to this growable array at the specified index. The possible values at and to the right
     * of the specified index are shifted to the right by one. Size is increased by one if an exception is not thrown.
     *
     * If size is equal to the length of the values array, double the capacity of the array, leaving the original values
     * in place, before shifting the values.
     *
     * @param index the index at which the specified value will be added
     * @param value the value to be added
     * @throws IndexOutOfBoundsException if the {@code index} argument is out of bounds
     * {@code (index < 0 || index > size())}
     */
    public void add(int index, T value) throws IndexOutOfBoundsException
    {
        Object[]    newArr;

                    //System.out.println(index + " " + size());

                    if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
                    else if(size() == values.length)
                    {
                        newArr = new Object[values.length * 2];

                        size = 0;
                        int i = 0;
                        for(i = 0; i < values.length; i++)
                        {
                            newArr[i] = values[i];
                            size++;
                        }
                        newArr[index] = value;
                        size++;
                        values = newArr;
                    }
                    else
                    {
                                newArr = new Object[values.length];

                                for(int i = 0; i < values.length; i++)
                                {
                                    if(i >= index && (i + 1) < values.length)
                                    {
                                        newArr[i + 1] = values[i];
                                    }
                                    else
                                    {
                                        newArr[i] = values[i];
                                    }
                                }

                                this.values = newArr;
                                values[index] = value;
                                size++;
                    }
    } //add

    /**
     * Gets the value at the specified index in this growable array.
     *
     * @param index the index of the value to be retrieved
     * @return the value at the specified index in this growable array
     * @throws IndexOutOfBoundsException if the {@code index} argument is out of bounds
     * {@code (index < 0 || index >= size())}
     */
    @SuppressWarnings("unchecked")
    public T get(int index) throws IndexOutOfBoundsException
    {
        T   newVal = null;

            if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
            else
            {
                newVal = (T) values[index];
            }


        return newVal;
    } //get

    /**
     * Sets the value at the specified index in this growable array. Size does not change.
     *
     * @param index the index at which the value will be set
     * @param value the value to replace the existing value
     * @return the value previously held at the specified index
     * @throws IndexOutOfBoundsException if the {@code index} argument is out of bounds
     * {@code (index < 0 || index >= size())}
     */
    public T set(int index, T value) throws IndexOutOfBoundsException
    {
        T       temp = null;

                if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
                else
                {
                    temp = (T) values[index];

                    values[index] = value;
                }

        return temp;
    } //set

    /**
     * Gets the index of the first occurrence of the specified object in this growable array, or {@code -1} if it could
     * not be found.
     *
     * @param object the object to be searched for
     * @return the index of the first occurrence of the specified object in this growable array, or {@code -1} if it
     * could not be found
     */
    public int indexOf(Object object)
    {
        int index = -1;

            for(int i = 0; i < size(); i++)
            {
                if(values[i] != null && object != null && values[i].equals(object))
                {
                    index = i;
                    break;
                }
                else if(values[i] == null && object == null)
                {
                    index = i;
                    break;
                }
            }

        return index;
    } //indexOf
    
    /**
     * Removes the value at the specified index in this growable array. The possible values to the right of the
     * specified index are shifted to the left by one. Size is decreased by one if an exception is not thrown.
     *
     * @param index the index of the value to be removed
     * @return the value removed at the specified index
     * @throws IndexOutOfBoundsException if the {@code index} argument is out of bounds
     * {@code (index < 0 || index >= size())}
     */
    public T remove(int index) throws IndexOutOfBoundsException
    {
        T           retVal = null;
        Object[]    newArr;

                    if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
                    else
                    {
                        newArr = new Object[values.length];

                        for(int i = 0; i < values.length; i++)
                        {
                            if(i >= index)
                            {
                                retVal = (T) values[i];
                                newArr[i] = values[i + 1];
                            }
                            else newArr[i] = values[i];
                        }

                        values = newArr;

                        size--;
                    }

        return retVal;
    } //remove

    /**
     * Clears the values in this growable array and resets the size to 0.
     */
    public void clear()
    {
        for(int i = 0; i < size(); i++)
        {
            values[i] = null;
        }

        size = 0;
    } //clear

    /**
     * Determines whether or not this growable array is empty based on the variable size.
     *
     * @return {@code true}, if this growable array is empty, and {@code false} otherwise
     */
    public boolean isEmpty()
    {
        boolean empty;

                if(size > 0) empty = false;
                else empty = true;

        return empty;
    } //isEmpty

    /**
     * Gets the size of this growable array. The size is equal to the number of elements successfully added minus the
     * number of elements successfully removed (which is to say, you should modify the size variable when those methods
     * are called).
     *
     * @return the size of this growable array
     */
    public int size()
    {
    	return size;
    } //size

    /**
     * Determines whether or not the specified object is equal to this growable array. {@code true} is returned if and
     * only if the specified object is an instance of {@code GrowableArray}, and its size and values are equal to this
     * growable array's.
     *
     * @param object the object to be compared
     * @return {@code true}, if the specified object is equal to this growable array, and {@code false} otherwise
     */
    public boolean equals(Object object)
    {
        boolean equal = false;

                if(object instanceof GrowableArray)
                {
                    if(((GrowableArray) object).size() == this.size())
                    {
                        for(int i = 0; i < ((GrowableArray) object).values.length; i++)
                        {
                            if(((GrowableArray) object).values[i] == this.values[i]) equal = true;
                            else
                            {
                                equal = false;
                                break;
                            }
                        }
                    }
                }

        return equal;
    } //equals

    /**
     * Gets a {@code String} representation of this growable array. The returned {@code String} is of the form
     * {@code {v[0], v[1], ... , v[n]}}, where {@code v} is the values of this growable array.
     *
     * @return a {@code String} representation of this growable array
     */
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < this.size - 1; i++)
        {
            stringBuilder.append(this.values[i]);

            stringBuilder.append(", ");
        } //end for

        if (this.size != 0) {
            stringBuilder.append(this.values[this.size - 1]);
        } //end if

        stringBuilder.append("}");

        return stringBuilder.toString();
    } //toString

    public static void main(String[] args)
    {
        GrowableArray   test = new GrowableArray();

                        for(int i = 0; i < 12; i++)
                        {
                            test.add(i, i);
                        }

                        System.out.println(test.toString());

                        /*for(int i = 10; i < 20; i++)
                        {
                            test.add(i, i);
                        }

                        System.out.println(test.toString());*/
    }
}