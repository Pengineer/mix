package edu.whut.enumeration;
/**
 * 
 * @Description:����������ö����
 *
 */
public class EnumTest2 {
	//��EnumTest1��ͬ���ǣ�����û��ʹ�ò��Է�����ֱ��run as > java application��
	public static void main(String[] arg){
		System.out.println(stu.A.getGrade());
	} 
	
	enum stu{
		//ö�������У���Ҫ���ݲ�������Ҫ��д���󷽷�
		A("90-100"){  
			public String getGrade(){
				return "����";
			}
		},
		
		B("80-89"){
			public String getGrade(){
				return "����";
			}
		},
		
		C("70-79"){
			public String getGrade(){
				return "�е�";
			}
		},
		
		D("60-69")
		{
			public String getGrade(){
				return "����";
			}
		},
		
		E("1-59"){
			public String getGrade(){
				return "������";
			}
		},
		
		F("0"){
			public String getGrade(){
				return "ȱ��";
			}
		};
		
		private String value;
		
		//���췽��
		private stu(String value){  
			this.value = value;
		}
		
		//��Ա����
		public String getValue(){
			return this.value;
		} 
		
		//���󷽷�:ÿ�������ζ��еȼ������ȼ�����һ��������ó��󷽷������巽���ɶ���ʵ��
		public abstract String getGrade();
	}
}
