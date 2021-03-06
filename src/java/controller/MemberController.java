package controller;

import entities.Members;
import dao.MemberFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "memberController")
@RequestScoped
public class MemberController {

    private String firstName;
    private String surname;
    private String email;
    private String gender;
    private Date birthDate;
    private Long phoneNumber;
    private Long id;
    private List memList;
    private Members mem;
    
    private List<Members> fullList;
     
    @Inject
    MemberFacade mf;

    public MemberController() {
    }

    public List<Integer> getMemList() {

        memList = new ArrayList<>();
        for (Members m : mf.findAll()) {
            memList.add(m.getId());
        }
        return memList;
    }

    public void setMemList(List memList) {
        this.memList = memList;
    }

    public List<Members> getFullList() {
        fullList = mf.findAll();
        return fullList;
    }
    

    public void setFullList(List<Members> fullList) {
        this.fullList = fullList;
    }
    
   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Members getMem() {
        return mem;
    }

    public void setMem(Members mem) {
        this.mem = mem;
    }

    public MemberFacade getMf() {
        return mf;
    }

    public void setMf(MemberFacade mf) {
        this.mf = mf;
    }

    public String createNewMember() {
        Members m = new Members();
        m.setFirstName(firstName);
        m.setSurname(surname);
        m.setPhoneNumber(phoneNumber);
        m.setEmail(email);
        m.setBirthDate(birthDate);
        m.setGender(gender);
        mf.create(m);
        return "form";

    }

    public void deleteMember() {
        mf.remove(mf.find(id));
    }

    public String updateMember() {
        Members m = new Members();
        m.setFirstName(firstName);
        m.setSurname(surname);
        m.setPhoneNumber(phoneNumber);
        m.setEmail(email);
        m.setBirthDate(birthDate);
        m.setGender(gender);
        mf.edit(m);
        return "form";

    }

    public void loadMembers() {
        mem = mf.find(id);
        this.firstName = mem.getFirstName();
        this.surname = mem.getSurname();
        this.birthDate = mem.getBirthDate();
        this.gender = mem.getGender();
        this.phoneNumber = mem.getPhoneNumber();
        this.email = mem.getEmail();
    }

}
// Movie movie = new Movie(firstInput,year,service.selectGenre(genreInput));
//      /*  movie.setTitle(firstInput);
//        movie.setGenre(service.selectGenre(genreInput));
//        movie.setProductionYear(year);*/
//        mDao.createMovie(movie);
//    }
