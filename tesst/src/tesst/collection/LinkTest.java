package tesst.collection;

public class LinkTest<T> {
	//表头设置
	private DNode<T> head;
	//链表长度设置
	private int count;
	//双向链表节点对应的结构体
	private class DNode<T>{
		//前驱节点
		public DNode prev;
		//后继节点
		public DNode next;
		//设置节点的值
		public T value;
		
		public DNode(DNode prev,DNode next,T value) {
			this.prev=prev;
			this.next=next;
			this.value=value;
		}
	}
		
		public LinkTest(){
			//创建表头，表头没有数据
			head=new DNode<T>(null, null, null);
			head.next=head.prev=head;
			//初始化节点个数为0
			count=0;
	}
		//返回节点个数
		public int size() {
			return this.count;
		}
		
		//返回链表是否为空
		public boolean isEmpty() {
			return count==0;
		}
		
		//获取第index位置的节点
		private DNode<T> getNode(int index){
			if(index<0||index>=count) {
				throw new IndexOutOfBoundsException("输入的index数目有误");
			}
			//如果是正向查找
			if(index<count/2) {
					DNode<T> lnode=head.next;
					for(int i=0;i<index;i++) 
						lnode=lnode.next;
					return lnode;
			}
			//否则反向查找
			DNode<T> rnode=head.prev;
			int rindex=count-index-1;
			for(int i=0;i<rindex;i++) {
				rnode=rnode.prev;
			}
			return rnode;
		}
		
		//向第index位置插入t
		public void insert(int index,T t){
			if(index==0) {
				DNode<T> node=new DNode<T>(head, head.next, t);
				head.next.prev=node;
				head.next=node;
				count++;
				return;
			}
			//否则插入的位置应该是node之前与node之间的位置
			DNode<T> node=getNode(index);
			DNode<T> tNode=new DNode<T>(node.prev,node, t);
			node.prev.next=tNode;
			tNode.prev=node.prev;
			tNode.next=node;
			node.prev=tNode;
			count++;
			return;
					
		}
		
		
		
		public static void main(String[] args) {
			LinkTest<Integer> doubleLink=new LinkTest<>();
			for(int i=0;i<5;i++) {
				doubleLink.insert(i, i+2);
			}
			System.out.println(doubleLink.size());
//			System.out.println(doubleLink.getNode(3).value);
					
		}
		
}
