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
			int flag=i;//保存最小的数的下标，首先默认为第一个
			for(int j=i+1;j<number;j++){
				if(demo[j]<demo[flag])
					flag=j;//向右查找是否有比默认更小的数，如果有，记录下标
			}
			if(flag!=i){//交换
				int temp=demo[flag];
				demo[flag]=demo[i];
				demo[i]=temp;
			}	
		}
	}
	
	void bubble_sort(int []demo,int number){
		for(int i=0;i<number-1;i++){
			for(int j=0;j<number-1-i;j++){//比较数组前后两个元素的大小，如果前面的比后面的大就两两交换
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
		for(int i=1;i<var1;i*=2){//步长
			for(left_min=0;left_min<var1-i;left_min=right_max){//将数组分为left，right两部分
				right_min=left_max=left_min+i;//右边的起始位置
				right_max=left_max+i;
				if(right_max>var1)
					right_max=var1;
			next=0;
			while(left_min<left_max&&right_min<right_max)//从左边右边的数组里的数最小的放进temp数组
				temp[next++]=demo[left_min]>demo[right_min]?demo[right_min++]:demo[left_min++];
			while(left_min<left_max)//把剩下的元素放入temp数组
				demo[--right_min]=demo[--left_max];
			while(next>0)//复制回原数组
				demo[--right_min]=temp[--next];
			}
			
		}
	}
	
	void quick_sort(int[] demo,int left,int right){
		int i=left;//默认最左边的为哨兵1
		int j=right;//最右边为哨兵2
		if(left>right)
		       return;
		int temp=demo[left];//以左边哨兵为参照物
		while(i!=j){//直到ij相遇，一轮排序完成
			while(i<j&&demo[j]>=temp) //从right往左走
				j--;
			if(j>i)//如果找到比参照物小的数，把这个数付给left
				demo[i]=demo[j];
			while(i<j&&demo[i]<=temp) //从left往左走
				i++;
			if(i<j)//找到比参照物大的数，把这个数付给right
				demo[j]=demo[i];

		}
		demo[i]=temp;//排好参照物的位置
		quick_sort(demo,left,i-1);//排参照物的左边
		quick_sort(demo,i+1,right);//排参照物的右边
		
		
	}
	void insert_sort(int[] demo,int number){
		for(int i=1;i<number;i++){
			int temp=demo[i];//待插元素
			int index=i-1;
			while(index>=0&&temp<demo[index]){
				demo[index+1]=demo[index];//大于temp的往后移
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
		
		
		jbtn=new JButton("确定");
		jcb1=new JComboBox(number);//数据规模
		jcb2=new JCheckBox("选择");//排序类别
		jcb3=new JCheckBox("冒泡");
		jcb4=new JCheckBox("合并");
		jcb5=new JCheckBox("快速");
		jcb6=new JCheckBox("插入");
		
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
				int index1=jcb1.getSelectedIndex();//数据规模的数在数组的下标
				int var1= Integer.parseInt(number[index1]);//数据规模大小
				
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
						
					//	for(int i=0;i<var1;i++){//排序后的输出
					//		jta.append(demo2[i]+" ");
					//	}
							
						jta.append("选择排序："+(endTime-startTime)/1000000.0+"ms"+"\r\n");
							
					}
					 if(jcb3.isSelected()==true){
						long startTime=System.nanoTime();
						bubble_sort(demo3,var1);
						long endTime=System.nanoTime();
						totalTime2+=(endTime-startTime)/1000000.0;

					//	for(int i=0;i<var1;i++){//排序后的输出
					//		jta.append(demo3[i]+" ");
					//	}
							
						jta.append("冒泡排序："+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					}
					 if(jcb4.isSelected()==true){
						long startTime=System.nanoTime();
						merge_sort(demo4,var1);
						long endTime=System.nanoTime();
						totalTime3+=(endTime-startTime)/1000000.0;
						
					//	for(int i=0;i<var1;i++){//排序后的输出
					//		jta.append(demo4[i]+" ");
					//	}
						jta.append("合并排序："+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					
					}
					 if(jcb5.isSelected()==true){
						long startTime=System.nanoTime();
						quick_sort(demo5,0,var1-1);
						long endTime=System.nanoTime();
						totalTime4+=(endTime-startTime)/1000000.0;
					//	for(int i=0;i<var1;i++){//排序后的输出
					//		jta.append(demo5[i]+" ");
					//	}
						jta.append("快速排序："+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					
					}
					 if(jcb6.isSelected()==true){
						long startTime=System.nanoTime();
						insert_sort(demo6,var1);
						long endTime=System.nanoTime();
						totalTime5+=(endTime-startTime)/1000000.0;
					//	for(int i=0;i<var1;i++){//排序后的输出
					//		jta.append(demo6[i]+" ");
					//	}
				
						jta.append("插入排序："+(endTime-startTime)/1000000.0+"ms"+"\r\n");
						
					}
				
					
				}
				
				jta.append("-----------------------------------------------------------------------------------------------------"+"\r\n");
				if(jcb2.isSelected()==true){
					jta.append("选择平均时间："+totalTime1/20.0+"ms"+"\r\n");
				}
				if(jcb3.isSelected()==true){
					jta.append("冒泡平均时间："+totalTime2/20.0+"ms"+"\r\n");
				}
				if(jcb4.isSelected()==true){
					jta.append("合并平均时间："+totalTime3/20.0+"ms"+"\r\n");
				}
				if(jcb5.isSelected()==true){
					jta.append("快速平均时间："+totalTime4/20.0+"ms"+"\r\n");
				}
				if(jcb6.isSelected()==true){
					jta.append("插入平均时间："+totalTime5/20.0+"ms"+"\r\n");
				}
				
					
			}
			
		});
		
		
		
		
		f.setLocationRelativeTo(null);//窗口位置居中
		jta.setLineWrap(true);
		f.validate();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	public static void main(String args[]){
		new KindOfSort("sort");
		
	}

}