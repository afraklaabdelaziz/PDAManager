<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/23/2022
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="static.jsp"%>

<div>
    <div class="bg-white mx-auto text-center w-1/2 py-5 shadow-xl rounded-3xl">
        <h2 class="text-4xl font-semibold border-b pb-2 mx-6">Login</h2>
        <!-- If the error attribute is present in the forwarded request, display it -->
        <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto"></h3>
        <div>
            <form method="post">

                <div class="grid grid-cols-2 gap-4 my-5 mx-8">

                    <label class="text-xl flex items-center">Email :</label>
                    <input type="email"  name="email" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2">

                    <label class="text-xl flex items-center">password :</label>
                    <input type="password" name="password" class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2">

                </div>

                <button type="submit" class="bg-blue-300 text-xl font-semibold px-4 py-1 rounded-lg hover:bg-blue-800 hover:text-white">Register</button><br><br>

            </form>
        </div>
    </div>
</div>
</body>
</html>
