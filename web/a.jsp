<%@ page import="com.atiguigu.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 范
  Date: 2021/11/8
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Person person = new Person();
    person.setName("fan");
    person.setPhones(new String[]{"15295082585", "15189952420", "18252685737"});
    ArrayList list = new ArrayList();
    list.add("北京");
    list.add("上海");
    list.add("深圳");
    person.setCities(list);
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    person.setMap(map);
    request.setAttribute("person",person);
%>
姓名是:${person.name}
手机是:${person.phones[0]} ${person.phones[1]} ${person.phones[2]}
城市是:${person.cities[0]} ${person.cities[1]} ${person.cities[2]}
map集合是:${person.map.key1} ${person.map.key2} ${person.map.key3}
</body>
</html>
