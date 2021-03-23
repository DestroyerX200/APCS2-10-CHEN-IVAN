public class MyDeque<E> {
	private E[] data;
	private int size, start, end;

	public MyDeque() {
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 9;
    end = 0;
	}
	public MyDeque(int initialCapacity) {
		@SuppressWarnings("unchecked")
		E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = initialCapacity-1;
    end = 0;
	}
}