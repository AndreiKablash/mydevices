<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>


<%--@elvariable id="device" type="by.pvt.pojo.device.Device"--%>
<form:form method="POST" name="form1" action="${pageContext.request.contextPath}/add-device" modelAttribute="device">
    <div class="form-row">
        <div class="form-group col-md-4">
            <form:label path="deviceType">Device Type</form:label>
            <form:select  path="deviceType" class="form-control">
                <option disabled selected>Choose Device Type</option>
                <option>KETTLE</option>
                <option>TV</option>
                <option>COOKER</option>
                <option>WASHING</option>
                <option>FRIDGE</option>
                <option>AIRCON</option>
                <option>CLEANER</option>
                <option>COFFEE</option>
            </form:select>
            <div class="valid-feedback">
                <form:errors path="deviceType" />
            </div>
        </div>
        <div class="form-group col-md-6">
            <form:label path="deviceName">Device name</form:label>
            <form:input path="deviceName" type="text" class="form-control" placeholder="Device model"/>
            <div class="valid-feedback">
                <form:errors path="deviceName"/>
            </div>
        </div>

    </div>

    <%--@elvariable id="sensor" type="by.pvt.pojo.device.Sensor"--%>
    <form:form method="post" name="form2" modelAttribute="sensor">
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label path="sensorType">Sensor Type</form:label>
                <form:select path="sensorType"  class="form-control">
                    <option disabled selected>Choose Sensor Type</option>
                    <option>OTHER</option>
                    <option>TEMP</option>
                    <option>LIGHT</option>
                    <option>AIR</option>
                    <option>ARRIVAL</option>
                    <option>MOTION</option>
                </form:select>
                <div class="valid-feedback">
                    <form:errors path="sensorType"/>
                </div>
            </div>
            <div class="form-group col-md-6">
                <form:label path="sensorName">Sensor name</form:label>
                <form:input path="sensorName" type="text" name="sensorName" class="form-control" placeholder="Sensor model" />
                <div class="valid-feedback">
                    <form:errors path="sensorName"/>
                </div>
            </div>
        </div>

        <button type="submitForms" class="btn btn-primary">Submit</button>
        <script>
            submitForms = function(){
                document.forms["form1"].submit();
                setTimeOut(function() {
                    document.forms["form2"].submit();
                }, 5000);
            }
        </script>
    </form:form>

</form:form>


<jsp:include page="footer.jsp"/>
