package estructuras;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

	private int size;
	private LinkedStack<E>.NodeStack<E> node;
	
	private class NodeStack<T>{
		private NodeStack next;
		private T element;
		public NodeStack(T element){
			this.element = element;
		}
		public NodeStack getNextNode(){
			return next;
		}
		public T getElement(){
			return element;
		}
		public void setNext(NodeStack next){
			this.next = next;
		}
		public void setElement(T element){
			this.element=element;
		}
	}
	
	public LinkedStack(){
	}
	
	
	@Override
	public boolean add(E arg0) {
		this.push(arg0);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		Iterator<?> it = arg0.iterator();
		while(it.hasNext()){
			this.add((E) it.next());
		}
		return true;
	}

	@Override
	public void clear() {
		size=0;
		this.node = new NodeStack<>(null);
	}

	@Override
	public boolean contains(Object arg0) {
		Iterator<E> it = iterator();
		while(it.hasNext()){
			if(arg0.equals(it.next()))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		Iterator<?> it = arg0.iterator();
		while(it.hasNext()){
			Object next = it.next();
			Iterator<E> it2 = iterator();
			boolean flag = false;
			while(it2.hasNext()){
				if(next.equals(it2.next()))
					flag=true;
			}
			if(!flag)
				return false;
			
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterador<>();
	}
	
	private class Iterador<T> implements Iterator<T>{

		private int size;
		private int returned;
		private LinkedStack<T>.NodeStack<T> current;
		
		@SuppressWarnings("unchecked")
		public Iterador(){
			this.current = (LinkedStack<T>.NodeStack<T>) node;
			this.size = size();
		}
		
		@Override
		public boolean hasNext() {
			return size!=returned;
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new NoSuchElementException();
			else{
				returned++;
				T swap = current.getElement();
				node=current.getNextNode();
				return swap;
			}
			
		}
		
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		Iterator<?> it = arg0.iterator();
		NodeStack<E> node=null;
		NodeStack<E> temp=null;
		while(it.hasNext()){
			Object next = it.next();
			if(contains(next)){
				temp = new NodeStack<>((E)next);
				if(node==null){
					node=temp;
				}else{
					temp.setNext(node);
					node=temp;
				}
			}				
		}
		if(node==null)
			return false;
		else{
			this.node=node;
			return true;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pull() {
		if(this.node.getElement()==null)
			throw new NoSuchElementException();
		else{
			E ret = this.node.getElement();
			if(this.node.getNextNode()!=null)
				this.node=this.node.getNextNode();
			size--;
			return ret;
		}
	}

	@Override
	public void push(E element) {
		if(this.node.getElement()==null)
			this.node.setElement(element);
		else{
			NodeStack<E> nodeTemp = new NodeStack<>(element);
			nodeTemp.setNext(this.node);
			this.node=nodeTemp;
		}
		size++;
	}

}
