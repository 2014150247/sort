import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class KindOfSort {
	JFrame f;
	JPanel jp;
	JComboBox jcb1;
	JComboBox jcb2;
	JTextArea jta;
	JButton jbtn;
	JScrollPane jsp;
	String[] number={"10","100","1000","10000","100000"};
	String[] kind={"选择排序","冒泡排序","合并排序","快速排序","插入排序"};
	
	
	void select_sort(int []demo,int number){
		for(int i=0;i<number-1;i++){
			int flag=i;
			for(int j=i+1;j<number;j++){
				if(demo[j]<demo[flag])
					flag=j;
			}
			if(flag!=i){
				int temp=demo[flag];
				demo[flag]=demo[i];
				demo[i]=temp;
			}
			
		}
	}
	
	void bubble_sort(int []demo,int number){
		for(int i=0;i<number;i++){
			for(int j=0;j<i;j++){
				if(demo[j]>demo[i]){
					int temp=demo[j];
					demo[j]=demo[i];
					demo[i]=temp;
				}
			}
		}
	}
	
	void merge_sort(int []demo,int var1){
		int []temp=new int[var1];
		int left_min,left_max,right_min,right_max,next;
		for(int i=1;i<var1;i*=2){
			for(left_min=0;left_min<var1-i;left_min=right_max){
				right_min=left_max=left_min+i;
				right_max=left_max+i;
				if(right_max>var1)
					right_max=var1;
			next=0;
			while(left_min<left_max&&right_min<right_max)
				temp[next++]=demo[left_min]>demo[right_min]?demo[right_min++]:demo[left_min++];
			while(left_min<left_max)
				demo[--right_min]=demo[--left_max];
			while(next>0)
				demo[--right_min]=temp[--next];
			}
			
		}
	}
	
	void quick_sort(int[] demo,int left,int right){
		int i=left;
		int j=right;
		if(left>right)
		       return;
		int temp=demo[left];
		while(i!=j){
			while(i<j&&demo[j]>=temp) 
				j--;
			if(j>i)
				demo[i]=demo[j];
			while(i<j&&demo[i]<=temp) 
				i++;
			if(i<j)
				demo[j]=demo[i];

		}
		demo[i]=temp;
		quick_sort(demo,left,i-1);
		quick_sort(demo,i+1,right);
		
		
	}
	void insert_sort(int[] demo,int number){
		for(int i=1;i<number;i++){
			int temp=demo[i];
			int index=i-1;
			while(index>=0&&temp<demo[index]){
				demo[index+1]=demo[index];
				index--;
			}
			demo[index+1]=temp;
			
		}	
	}


	KindOfSort(String title){
		jp=new JPanel();
		f=new JFrame();
		jta=new JTextArea();
		
		
		jbtn=new JButton("确定");
		jcb1=new JComboBox(number);
		jcb2=new JComboBox(kind);
		f.getContentPane().setBackground(Color.orange);
		f.setLayout(new BorderLayout());
		jp.setLayout(new BorderLayout());
		f.setTitle(title);
		f.setVisible(true);
		f.setSize(500,500);
		jp.add(jcb1,BorderLayout.WEST);
		jp.add(jbtn,BorderLayout.EAST);
		jp.add(jcb2,BorderLayout.CENTER);
		f.add(new JScrollPane(jta),BorderLayout.CENTER);
		f.add(jp,BorderLayout.SOUTH);
		
		jbtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index1=jcb1.getSelectedIndex();
				int var1= Integer.parseInt(number[index1]);
				int index2=jcb2.getSelectedIndex();
				if(jta.getText()!=null){
					jta.setText("");
				}
				int demo[]=new int[var1];
				Random random = new Random();
				double totalTime=0;
				
				for(int group=0;group<20;group++){
					jta.append(group+1+":"+"\r\n");
					
					for(int i=0;i<var1;i++){
						demo[i]=random.nextInt(var1 *5);
					//	jta.append(demo[i]+" ");
					}
					//jta.append("\r\n");
					long startTime=System.nanoTime();
					if(index2==0){
						select_sort(demo,var1);
					}
					else if(index2==1){
						bubble_sort(demo,var1);
					}
					else if(index2==2){
						merge_sort(demo,var1);
					}
					else if(index2==3){
						quick_sort(demo,0,var1-1);
					}
					else if(index2==4){
						insert_sort(demo,var1);
					}
				//	for(int i=0;i<var1;i++){
				//		jta.append(demo[i]+" ");
				//	}
					long endTime=System.nanoTime();
				//	jta.append("\r\n");
					jta.append((endTime-startTime)/1000000.0+"ms"+"\r\n");
					jta.append("-----------------------------------------------------------------------------------------------------"+"\r\n");
					totalTime+=(endTime-startTime)/1000000.0;
					
				}
				jta.append("平均时间："+totalTime/20.0+"ms"+"\r\n");
				
					
			}
			
		});
		
		
		
		
		f.setLocationRelativeTo(null);
		jta.setLineWrap(true);
		f.validate();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	public static void main(String args[]){
		new KindOfSort("sort");
		
	}

}