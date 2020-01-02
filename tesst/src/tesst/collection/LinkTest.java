package tesst.collection;

public class LinkTest<T> {
	//��ͷ����
	private DNode<T> head;
	//����������
	private int count;
	//˫������ڵ��Ӧ�Ľṹ��
	private class DNode<T>{
		//ǰ���ڵ�
		public DNode prev;
		//��̽ڵ�
		public DNode next;
		//���ýڵ��ֵ
		public T value;
		
		public DNode(DNode prev,DNode next,T value) {
			this.prev=prev;
			this.next=next;
			this.value=value;
		}
	}
		
		public LinkTest(){
			//������ͷ����ͷû������
			head=new DNode<T>(null, null, null);
			head.next=head.prev=head;
			//��ʼ���ڵ����Ϊ0
			count=0;
	}
		//���ؽڵ����
		public int size() {
			return this.count;
		}
		
		//���������Ƿ�Ϊ��
		public boolean isEmpty() {
			return count==0;
		}
		
		//��ȡ��indexλ�õĽڵ�
		private DNode<T> getNode(int index){
			if(index<0||index>=count) {
				throw new IndexOutOfBoundsException("�����index��Ŀ����");
			}
			//������������
			if(index<count/2) {
					DNode<T> lnode=head.next;
					for(int i=0;i<index;i++) 
						lnode=lnode.next;
					return lnode;
			}
			//���������
			DNode<T> rnode=head.prev;
			int rindex=count-index-1;
			for(int i=0;i<rindex;i++) {
				rnode=rnode.prev;
			}
			return rnode;
		}
		
		//���indexλ�ò���t
		public void insert(int index,T t){
			if(index==0) {
				DNode<T> node=new DNode<T>(head, head.next, t);
				head.next.prev=node;
				head.next=node;
				count++;
				return;
			}
			//��������λ��Ӧ����node֮ǰ��node֮���λ��
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
