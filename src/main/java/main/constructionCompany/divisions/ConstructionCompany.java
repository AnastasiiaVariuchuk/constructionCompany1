package main.constructionCompany.divisions;

import main.constructionCompany.divisions.department.catalog.Department;
import main.constructionCompany.estimates.IDiscountCustomerFinder;
import main.constructionCompany.people.architect.catalog.ArchitectCatalog;
import main.constructionCompany.people.customer.Customer;
import main.constructionCompany.people.employees.Employee;
import main.constructionCompany.people.employees.catalog.EmployeeCatalog;
import main.constructionCompany.projects.bathhouseProject.BathhouseProject;
import main.constructionCompany.projects.highriseBuilding.HighriseBuilding;
import main.constructionCompany.projects.houseProject.HouseProject;
import main.constructionCompany.projects.project.Project;
import main.constructionCompany.reserves.material.Material;
import main.constructionCompany.reserves.technique.Technique;

import java.util.List;
import java.util.Objects;

public class ConstructionCompany implements IDiscountCustomerFinder {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private List<Department> departments;
    private List<Technique> techniques;
    private List<Material> materials;
    private List<HouseProject> houseProjects;
    private List<HighriseBuilding> highriseBuildings;
    private List<BathhouseProject> bathhouseProjects;
    private List<Customer> customers;
    private List<Schedule> schedules;
    private List<Project> projects;

    public ConstructionCompany() {
    }

    public ConstructionCompany(String name, String address, String email,
                               String phoneNumber, List<Department> departments,
                               List<Technique> techniques, List<Material> materials,
                               List<HouseProject> houseProjects, List<HighriseBuilding> highriseBuildings,
                               List<BathhouseProject> bathhouseProjects, List<Project> projects,
                               List<Customer> customers) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.departments = departments;
        this.techniques = techniques;
        this.materials = materials;
        this.houseProjects = houseProjects;
        this.highriseBuildings = highriseBuildings;
        this.bathhouseProjects = bathhouseProjects;
        this.projects = projects;
        this.customers = customers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setTechniques(List<Technique> techniques) {
        this.techniques = techniques;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setHouseProjects(List<HouseProject> houseProjects) {
        this.houseProjects = houseProjects;
    }

    public List<HouseProject> getHouseProjects() {
        return houseProjects;
    }

    public void setHighriseBuildings(List<HighriseBuilding> highriseBuildings) {
        this.highriseBuildings = highriseBuildings;
    }

    public List<HighriseBuilding> getHighriseBuildings() {
        return highriseBuildings;
    }

    public void setBathhouseProjects(List<BathhouseProject> bathhouseProjects) {
        this.bathhouseProjects = bathhouseProjects;
    }

    public List<BathhouseProject> getBathhouseProjects() {
        return bathhouseProjects;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Construction Company [\nname => " + name
                + "\naddress => " + address
                + "\nphone number => " + phoneNumber
                + "\nemail => " + email
                + "\nlist of departments => " + departments.toString()
                + "\nlist of techniques => " + techniques.toString()
                + "\nlist of materials => " + materials.toString()
                + "\nlist of house projects => " + houseProjects.toString()
                + "\nlist of highrise buildings => " + highriseBuildings.toString()
                + "\nlist of bathhouse projects => " + bathhouseProjects.toString()
                + "\nschedules => " + schedules.toString()
                + "\nlist of projects => " + projects.toString()
                + "\nlist of customers => " + customers.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ConstructionCompany c = (ConstructionCompany) obj;
        return Objects.equals(name, c.name)
                && Objects.equals(address, c.address)
                && Objects.equals(phoneNumber, c.phoneNumber)
                && Objects.equals(email, c.email)
                && Objects.equals(departments, c.departments)
                && Objects.equals(techniques, c.techniques)
                && Objects.equals(materials, c.materials)
                && Objects.equals(bathhouseProjects, c.bathhouseProjects)
                && Objects.equals(highriseBuildings, c.highriseBuildings)
                && Objects.equals(houseProjects, c.houseProjects)
                && Objects.equals(schedules, c.schedules)
                && Objects.equals(projects, c.projects)
                && Objects.equals(customers, c.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.hashCode(), address.hashCode(), phoneNumber.hashCode(), email.hashCode(),
                materials.hashCode(), departments.hashCode(), techniques.hashCode(),
                schedules.hashCode(), bathhouseProjects.hashCode(), highriseBuildings.hashCode(),
                houseProjects.hashCode(), projects.hashCode(), customers.hashCode());
    }


    @Override
    public boolean isRegularCustomer(Customer customer) {  //left
        int i = 0;
        for (Project project : projects) {
            if (project.getCustomer().equals(customer)) {
                i += 1;
            }
        }
        if (i < 1) {
            return false;
        } else {
            return true; }
    }

    @Override
    public boolean isEmployee(Customer customer) {
        if (EmployeeCatalog.getEmployeeCatalog().findEmployeeByNameSurname(customer.getName(),customer.getSurname()) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isArchitect(Customer customer) {
        if (ArchitectCatalog.getArchitectCatalog().findArchitectByNameSurname(customer.getName(), customer.getSurname()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean idArchitect(Employee employee) {
        if (ArchitectCatalog.getArchitectCatalog().findArchitectByFullName(employee.getName(), employee.getSurname()) != null) {
            return true;
        } else {
            return false;
        }
    }


    /**

    @Override
    public List<Project> getProjectsForDiscount(Customer customer) {
        List<Project> p = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCustomer().equals(customer)) {
                p.add(project);
            }
        }
        return(p);
    }

    @Override
    public List<Double> getPriceWithDiscount(Customer customer) {
        List<Estimate> estimates = new ArrayList<>();
        List<Double> p = new ArrayList<>();
        if (this.isRegularCustomer(customer)) {
            for (Project project : this.getProjectsForDiscount(customer)) {
                estimates.add((Estimate) project.getEstimates());
            }
            for (Estimate estimate : estimates) {
                p.add(estimate.getPrice() - 0.2 * estimate.getPrice());
            }
        }
        return(p);
    }


    @Override
    public List<Double> getPriceWithDiscountForEmployee(Employee employee) {
        List<Project> employeeProjects = this.getProjectsForDiscount(isCustomer(employee));
        List<Estimate> estimates = new ArrayList<>();
        List<Double> p = new ArrayList<>();
        for (Project project : employeeProjects) {
                estimates.add((Estimate) project.getEstimates());
        }
        for (Estimate estimate : estimates) {
                p.add(estimate.getPrice() - 0.4 * estimate.getPrice());
        }
        return(p);
    }
    **/
}
