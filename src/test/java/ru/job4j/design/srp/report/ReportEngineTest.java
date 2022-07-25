package ru.job4j.design.srp.report;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.design.srp.report.ReportEngine.DATE_FORMAT;


import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ocp.JSONReportEngine;

import java.util.Calendar;

public class ReportEngineTest {

    public static final int MULTY = 12;
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateByHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 10);
        Employee worker3 = new Employee("Masha", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HREngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(DATE_FORMAT.format(worker3.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker3.getFired().getTime())).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(DATE_FORMAT.format(worker1.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker1.getFired().getTime())).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(DATE_FORMAT.format(worker2.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker2.getFired().getTime())).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateByCAO() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 10);
        Employee worker3 = new Employee("Masha", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new CAOEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary() * MULTY).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary() * MULTY).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary() * MULTY).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateByIT() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Oleg", now, now, 10);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ITEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<meta charset=\"utf-8\">").append(System.lineSeparator())
                .append("<title>таблица</title")
                .append("<head>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th>Name</th><th>Hired</th><Fired</th><th>Salary</th>")
                .append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker1.getName()).append("</td")
                .append("<td>").append(worker1.getHired()).append("</td")
                .append("<td>").append(worker1.getFired()).append("</td")
                .append("<td>").append(worker1.getSalary()).append("</td")
                .append("</tr>").append(System.lineSeparator())
                .append("<tr>")
                .append(System.lineSeparator())
                .append("<td>").append(worker2.getName()).append("</td")
                .append("<td>").append(worker2.getHired()).append("</td")
                .append("<td>").append(worker2.getFired()).append("</td")
                .append("<td>").append(worker2.getSalary()).append("</td")
                .append("</tr>").append(System.lineSeparator())
                .append("</table>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Ignore
    @Test
    public void whenGenerateJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        now.set(7, 2022);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report jsonEngine = new JSONReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("{\"name\":\"Ivan\",\"hired\":")
                .append("{\"year\":2022,\"month\":6,\"dayOfMonth\":22,"
                        + "\"hourOfDay\":21,\"minute\":7,\"second\":50},")
                .append("\"fired\":{\"year\":2022,\"month\":6,\"dayOfMonth\":22"
                        + ",\"hourOfDay\":21,\"minute\":7,\"second\":50},")
                .append("\"salary\":100.0}")
                .append(System.lineSeparator());
        System.out.println(expect);
        assertThat(jsonEngine.generate(em -> true), is(expect.toString()));
        /*
        {"name":"Ivan","hired":{"year":2022,"month":6,"dayOfMonth":24,"hourOfDay":20,"minute":55,"second":54},"fired":{"year":2022,"month":6,"dayOfMonth":24,"hourOfDay":20,"minute":55,"second":54},"salary":100.0}
         */
    }

}

