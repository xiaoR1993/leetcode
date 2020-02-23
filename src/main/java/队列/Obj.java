package 队列;

/**
 * @author 张业荣
 * @Description
 * @Date 2020/2/22
 */
public class Obj<E> implements Comparable<Obj>
{
	E value;
	Integer count;

	public Obj(E value, Integer count)
	{
		this.value = value;
		this.count = count;
	}

	@Override
	public int compareTo(Obj that)
	{
		return that.count - this.count;
	}
}
