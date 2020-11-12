package designpatterns.原型模式;

/**
 * 简历
 */
public class Resume implements Cloneable{
    private String name;
    private String sex;
    private String age;

    private WorkExperience work;

    private String timeArea;
    private String company;

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    public Resume(WorkExperience work) {
        this.work = (WorkExperience) work.Clone();
    }

    /**
     * 设置个人信息
     * @param sex
     * @param age
     */
    public void SetPersonalInfo(String sex,String age){
        this.sex = sex;
        this.age = age;
    }

    /**
     * 设置工作经历
     * @param timeArea
     * @param company
     */
    public void SetWorkExperience(String timeArea,String company){
       work.setWorkDate(timeArea);
       work.setCompany(company);
    }

    /**
     * 显示
     */
    public void Display(){
        System.out.println(name+sex+age);
        System.out.println("工作经历："+work.getWorkDate()+work.getCompany());
    }

    /**
     * 浅复制
     * @return
     */
    public Object shallowClone(){
      Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 深复制的简历对象
     * @return
     */
    public Object deepClone(){
        Resume obj = new Resume(this.work);
        obj.name = this.name;
        obj.sex = this.sex;
        obj.age = this.age;
        return obj;
    }
}
