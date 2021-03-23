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
			this();
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
		if (size==0) {
			return "{}";
		}
		String retStr ="{";
		for (int i=start; i<size; i++) {
			retStr+= data[i] + ", ";
		}
		for (int j=0; j<=end; j++) {
			retStr+= data[j] + ", ";
		}
		retStr = retStr.substring(0,retStr.length()-2);
		retStr += "}";
		return retStr;
	}
  public void addFirst(E element) throws NullPointerException {
  	if (element==null) {
  		throw new NullPointerException();
  	}
  	else {
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
  	else {
	  	end++;
	  	data[end] = element;
	  	if (size==1) {
	  		start=end;
	  	}
  	}
  }
}