<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="UTF-8"
 %>
 
<jsp:include page="fragments/head.jsp" />

<body>
<div class="table-title">
	<h3>Librairie Limoissa</h3>
</div>
<div class="addbook">
	<a href="<c:url value='ajouter.jsp'/>" class="nc">Ajouter un Livre</a>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-center">Titre</th>
<th class="text-center">Auteur</th>
<th class="text-center">Pays</th>
<th class="text-center">Prix</th>
<th class="text-center">Disponibilité</th>
<th class="text-center">Modifier</th>
<th class="text-center">Supprimer</th>
</tr>
</thead>
<tbody class="table-hover">
<tr>
<td class="text-left">Ready Getset</td>
<td class="text-left">John Doe</td>
<td class="text-left">France</td>
<td class="text-left">18.00 €</td>
<td class="text-center">Oui</td>
<td class="text-center"><a href="#" id="modif"></a></td>
<td class="text-center"><a href="#" id="supp"></a></td>
</tr>
<tr>
<td class="text-left">Ready Getset</td>
<td class="text-left">John Doe</td>
<td class="text-left">France</td>
<td class="text-left">18.00 €</td>
<td class="text-center">Oui</td>
<td class="text-center"><a href="#" id="modif"></a></td>
<td class="text-center"><a href="#" id="supp"></a></td>
</tr>
<tr>
<td class="text-left">Ready Getset</td>
<td class="text-left">John Doe</td>
<td class="text-left">France</td>
<td class="text-left">18.00 €</td>
<td class="text-center">Oui</td>
<td class="text-center"><a href="#" id="modif"></a></td>
<td class="text-center"><a href="#" id="supp"></a></td>
</tr>
<tr>
<td class="text-left">Ready Getset</td>
<td class="text-left">John Doe</td>
<td class="text-left">France</td>
<td class="text-left">18.00 €</td>
<td class="text-center">Oui</td>
<td class="text-center"><a href="#" id="modif"></a></td>
<td class="text-center"><a href="#" id="supp"></a></td>
</tr>
<tr>
<td class="text-left">Ready Getset</td>
<td class="text-left">John Doe</td>
<td class="text-left">France</td>
<td class="text-left">18.00 €</td>
<td class="text-center">Oui</td>
<td class="text-center"><a href="#" id="modif"></a></td>
<td class="text-center"><a href="#" id="supp"></a></td>
</tr>
</tbody>
</table>
  

  </body>