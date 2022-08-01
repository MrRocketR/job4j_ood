package ru.job4j.design.srp.report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XMLEngine implements Report {

    private Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public XMLEngine(Store store) {
        this.store = store;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees();
        employees.setEmployees(store.findBy(filter));
        var employee =  employees.getEmployees();
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new Employees(employee), writer);
            xml = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
}
