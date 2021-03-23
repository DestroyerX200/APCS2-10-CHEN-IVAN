import java.util.NoSuchElementException;
import java.util.Arrays;
public class MyDeque<E> {
	public E[] data;
	public int size, start, end;

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
		@SuppressWarnings("unchecked")
		E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = initialCapacity;
    end = -1;
	}

	public int size() {
		return size;
	}

	public String toString() {
		int length=data.length;
		String retStr ="{";
		int index = start;
		for (int i=0; i<size;) {
			if (data[index%length]!=null) {
				retStr+= data[index%length] + ", ";
				i++;
				index++;
			}
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
  	if (size==data.length) {
  		resize();
  	}
  	if (start==0) {
  		start = data.length-1;
  		data[start] = element;
  		size++;
  	}
  	else if (size==1) {
  		E temp = getFirst();
  		start=data.length-1;
  		end=0;
  		data[end] = temp;
  		data[start] = element;
  		size++;
  	}
  	else {
			size++;
	  	start--;
	  	data[start] = element;
	  	if (size==1) {
	  		end = start;
	  	}
	  }
  }
  public void addLast(E element) throws NullPointerException {
  	if (element==null) {
  		throw new NullPointerException();
  	}
  	if (size==data.length) {
  		resize();
  	}
  	if (end == data.length-1) {
  		end = 0;
  		data[end] = element;
  		size++;
  	}
  	else if (size==1) {
  		E temp = getFirst();
			start=data.length-1;
  		end=0;
  		data[start] = temp;
  		data[end] = element;
  		size++;
  	}
  	else {
			size++;
	  	end++;
	  	data[end] = element;
	  	if (size==1) {
	  		start=end;
	  	}
	  }
  }
  public E removeFirst() throws NoSuchElementException {
  	if (size==0) {
  		throw new NoSuchElementException();
  	}
  	E retVal = getFirst();
  	data[start] = null;
  	start++;
  	size--;
  	if (start == data.length) {
  		start = 0;
  	}
  	if(size==1) {
  		start=end;
  	}
  	if (size==0) {
  		start = data.length;
  		end=-1;
  	}
  	return retVal;
  }
  public E removeLast() throws NoSuchElementException {
  	if (size==0) {
  		throw new NoSuchElementException();
  	}
  	E retVal = getLast();
  	data[end] = null;
  	end--;
  	size--;
  	if (end == -1) {
  		end = data.length-1;
  	}
  	if(size==1) {
  		end = start;
  	}
  	if (size==0) {
  		start = data.length;
  		end = -1;
  	}
  	return retVal;
  }
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
  private void resize() {
  	@SuppressWarnings("unchecked")
		E[] newData = (E[]) new Object[2*data.length];
		int newSi = newData.length;
		int oldSi = data.length;
		while (oldSi > start) {
			oldSi--;
			if (data[oldSi]!=null) {
				newSi--;
				newData[newSi] = data[oldSi];
			}
		}
		int newEi = -1;
		int oldEi = -1;
		while (oldEi < end) {
			oldEi++;
			if (data[oldEi]!=null) {
				newEi++;
				newData[newEi] = data[oldEi];
			}
		}
		data = newData;
		start = newSi;
		end = newEi;
  }
}