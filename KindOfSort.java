import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class KindOfSort {
	JFrame f;
	JPanel jp;
	JPanel jp2;
	JComboBox jcb1;
	JCheckBox jcb2;
	JCheckBox jcb3;
	JCheckBox jcb4;
	JCheckBox jcb5;
	JCheckBox jcb6;
	JTextArea jta;
	JButton jbtn;
	JScrollPane jsp;
	String[] number={"10","100","1000","10000","100000"};
	
	
	void select_sort(int []demo,int number){
		for(int i=0;i<number-1;i++){
			int flag=i;//������С�������±꣬����Ĭ��Ϊ��һ��
			for(int j=i+1;j<number;j++){
				if(demo[j]<demo[flag])
					flag=j;//���Ҳ����Ƿ��б�Ĭ�ϸ�С����������У���¼�±�
			}
			if(flag!=i){//����
				int temp=demo[flag];
				demo[flag]=demo[i];
				demo[i]=temp;
			}	
		}
	}
	
	void bubble_sort(int []demo,int number){
		for(int i=0;i<number-1;i++){
			for(int j=0;j<number-1-i;j++){//�Ƚ�����ǰ������Ԫ�صĴ�С�����ǰ��ıȺ���Ĵ����������
				if(demo[j+1]<demo[j]){
					int temp=demo[j+1];
					demo[j+1]=demo[j];
					demo[j]=temp;
				}
			}
		}
	}
	
	void merge_sort(int []demo,int var1){
		int []temp=new int[var1];
		int left_min,left_max,right_min,right_max,next;
		for(int i=1;i<var1;i*=2){//����
			for(left_min=0;left_min<var1-i;left_min=right_max){//�������Ϊleft��right������
				right_min=left_max=left_min+i;//�ұߵ���ʼλ��
				right_max=left_max+i;
				if(right_max>var1)
					right_max=var1;
			next=0;
			while(left_min<left_max&&right_min<right_max)//������ұߵ������������С�ķŽ�temp����
				temp[next++]=demo[left_min]>demo[right_min]?demo[right_min++]:demo[left_min++];
			while(left_min<left_max)//��ʣ�µ�Ԫ�ط���temp����
				demo[--right_min]=demo[--left_max];
			while(next>0)//���ƻ�ԭ����
				demo[--right_min]=temp[--next];
			}
			
		}
	}
	
	void quick_sort(int[] demo,int left,int right){
		int i=left;//Ĭ������ߵ�Ϊ�ڱ�1
		int j=right;//���ұ�Ϊ�ڱ�2
		if(left>right)
		       return;
		int temp=demo[left];//������ڱ�Ϊ������
		while(i!=j){//ֱ��ij������һ���������
			while(i<j&&demo[j]>=temp) //��right������
				j--;
			if(j>i)//����ҵ��Ȳ�����С�����������������left
				demo[i]=demo[j];
			while(i<j&&demo[i]<=temp) //��left������
				i++;
			if(i<j)//�ҵ��Ȳ����������������������right
				demo[j]=demo[i];

		}
		demo[i]=temp;//�źò������λ��
		quick_sort(demo,left,i-1);//�Ų���������
		quick_sort(demo,i+1,right);//�Ų�������ұ�
		
		
	}
	void insert_sort(int[] demo,int number){
		for(int i=1;i<number;i++){
			int temp=demo[i];//����Ԫ��
			int index=i-1;
			while(index>=0&&temp<demo[index]){
				demo[index+1]=demo[index];//����temp��������
				index--;
			}
			demo[index+1]=temp;
			
		}	
	}


	KindOfSort(String title){
		jp=new JPanel();
		f=new JFrame();
		jta=new JTextArea();
		jp2=new JPanel();
		
		
		jbtn=new JButton("ȷ��");
		jcb1=new JComboBox(number);//���ݹ�ģ
		jcb2=new JCheckBox("ѡ��");//�������
		jcb3=new JCheckBox("ð��");
		jcb4=new JCheckBox("�ϲ�");
		jcb5=new JCheckBox("����");
		jcb6=new JCheckBox("����");
		
		//f.getContentPane().setBackground(Color.orange);
		f.setLayout(new BorderLayout());
		jp.setLayout(new BorderLayout());
		f.setTitle(title);
		f.setVisible(true);
		f.setSize(500,500);
		jp.add(jcb1,BorderLayout.WEST);
		jp.add(jbtn,BorderLayout.EAST);
		jp2.setLayout(new FlowLayout());
		jp.add(jp2,BorderLayout.CENTER);
		jp2.add(jcb2,FlowLayout.LEFT);
		jp2.add(jcb3,FlowLayout.LEFT);
		jp2.add(jcb4,FlowLayout.LEFT);
		jp2.add(jcb5,FlowLayout.LEFT);
		jp2.add(jcb6,FlowLayout.LEFT);
		
		f.add(new JScrollPane(jta),BorderLayout.CENTER);
		f.add(jp,BorderLayout.SOUTH);
		
		jbtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index1=jcb1.getSelectedIndex();//���ݹ�ģ������������±�
				int var1= Integer.parseInt(number[index1]);//���ݹ�ģ��С
				
				if(jta.getText()!=null){
					jta.setText("");
				}
				int demo[]=new int[var1];
				int demo2[]=new int[var1];
				int demo3[]=new int[var1];
				int demo4[]=new int[var1];
				int demo5[]=new int[var1];
				int demo6[]=new int[var1];
				
				Random random = new Random();
				double totalTime1=0;
				double totalTime2=0;
				double totalTime3=0;
				double totalTime4=0;
				double totalTime5=0;
				
				
				
				for(int group=0;group<20;group++){
					jta.append(group+1+":"+"\r\n");
					
					for(int i=0;i<var1;i++){
						demo[i]=random.nextInt(var1 *5);
					//	jta.append(demo[i]+" ");
						demo2[i]=demo[i];
						demo3[i]=demo[i];
						demo4[i]=demo[i];
						demo5[i]=demo[i];
						demo6[i]=demo[i];
					}
					//jta.append("\r\n");
					
					
					if(jcb2.isSelected()==true){
						long startTime=System.nanoTime();
						select_sort(demo2,var1);
						long endTime=System.nanoTime();
						totalTime1+=(endTime-startTime)/1000000.0;
						
					//	for(int i=0;i<var1;i++){//���������
					//		jta.append(demo2[i]+" ");
					//	}
							
						jta.append("ѡ������"+(endTime-startTime)/1000000.0+"ms"+"\r\n");
							
					}
					 if(jcb3.isSelected()==true){
						long startTime=System.nanoTime();
						bubble_sort(demo3,var1);
						long endTime=System.nanoTime();
						totalTime2+=(endTime-startTime)/1000000.0;

					//	for(int i=0;i<var1;i++){//���������
					//		jta.append(demo3[i]+" ");
					//	}
							
						jta.append("ð������"+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					}
					 if(jcb4.isSelected()==true){
						long startTime=System.nanoTime();
						merge_sort(demo4,var1);
						long endTime=System.nanoTime();
						totalTime3+=(endTime-startTime)/1000000.0;
						
					//	for(int i=0;i<var1;i++){//���������
					//		jta.append(demo4[i]+" ");
					//	}
						jta.append("�ϲ�����"+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					
					}
					 if(jcb5.isSelected()==true){
						long startTime=System.nanoTime();
						quick_sort(demo5,0,var1-1);
						long endTime=System.nanoTime();
						totalTime4+=(endTime-startTime)/1000000.0;
					//	for(int i=0;i<var1;i++){//���������
					//		jta.append(demo5[i]+" ");
					//	}
						jta.append("��������"+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					
					}
					 if(jcb6.isSelected()==true){
						long startTime=System.nanoTime();
						insert_sort(demo6,var1);
						long endTime=System.nanoTime();
						totalTime5+=(endTime-startTime)/1000000.0;
					//	for(int i=0;i<var1;i++){//���������
					//		jta.append(demo6[i]+" ");
					//	}
				
						jta.append("��������"+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					}
				
					
				}
				
				jta.append("-----------------------------------------------------------------------------------------------------"+"\r\n");
				if(jcb2.isSelected()==true){
					jta.append("ѡ��ƽ��ʱ�䣺"+totalTime1/20.0+"ms"+"\r\n");
				}
				if(jcb3.isSelected()==true){
					jta.append("ð��ƽ��ʱ�䣺"+totalTime2/20.0+"ms"+"\r\n");
				}
				if(jcb4.isSelected()==true){
					jta.append("�ϲ�ƽ��ʱ�䣺"+totalTime3/20.0+"ms"+"\r\n");
				}
				if(jcb5.isSelected()==true){
					jta.append("����ƽ��ʱ�䣺"+totalTime4/20.0+"ms"+"\r\n");
				}
				if(jcb6.isSelected()==true){
					jta.append("����ƽ��ʱ�䣺"+totalTime5/20.0+"ms"+"\r\n");
				}
				
					
			}
			
		});
		
		
		
		
		f.setLocationRelativeTo(null);//����λ�þ���
		jta.setLineWrap(true);
		f.validate();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	public static void main(String args[]){
		new KindOfSort("sort");
		
	}

}