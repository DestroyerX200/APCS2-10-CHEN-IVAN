import java.util.NoSuchElementException;
public class MyDeque<E> {
	private E[] data;
	private int size, start, end;

	public MyDeque() {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 10;
    end = -1;
	}

	public MyDeque(int initialCapacity) {
		if (initialCapacity < 10) {
			initialCapacity=10;
		}
		else {
			@SuppressWarnings("unchecked")
			E[] d = (E[])new Object[initialCapacity];
	    data = d;
	    size = 0;
	    start = initialCapacity;
	    end = -1;
	  }
	}

	public int size() {
		return size;
	}

	public String toString() {
		int length=data.length;
		String retStr ="{";
		int index = start;
		for (int i=0; i<size; i++) {
			retStr+= data[index%length] + ", ";
			index++;
		}
		if (retStr.length() > 2) {
			retStr = retStr.substring(0,retStr.length()-2);
		}
		retStr += "}";
		return retStr;
	}
  public void addFirst(E element) throws NullPointerException {
  	if (element==null) {
  		throw new NullPointerException();
  	}
  	if (start==0) {
  		start=size;
  	}
		size++;
  	start--;
  	data[start] = element;
  	if (size==1) {
  		end = start;
  	}
  }
  public void addLast(E element) throws NullPointerException {
  	if (element==null) {
  		throw new NullPointerException();
  	}
  	if (end==data.length-1) {
  		end=-1;
  	}
		size++;
  	end++;
  	data[end] = element;
  	if (size==1) {
  		start=end;
  	}
  }
  // public E removeFirst() throws NoSuchElementException {
  // 	if (size==0) {
  // 		throw new NoSuchElementException();
  // 	}
  // 	return;
  // }
  // public E removeLast() throws NoSuchElementException {
  // 	if (size==0) {
  // 		throw new NoSuchElementException();
  // 	}
  // 	return;
  // }
  public E getFirst() throws NoSuchElementException {
  	if (size==0) {
  		throw new NoSuchElementException();
  	}
  	return data[start];
  }
  public E getLast() throws NoSuchElementException {
  	if (size==0) {
  		throw new NoSuchElementException();
  	}
  	return data[end];
  }
}