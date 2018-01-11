<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="UTF-8"
 %>
 

<div class="table-title">
	<h3>Librairie Limoissa</h3>
</div>
<div class="addbook">
	<a href="<c:url value='/add'/>" class="nc">Ajouter un Livre</a>
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



		<c:forEach items="${books}" var ="book">
		<tr>
			<td class="text-left">${book.title }</td>
			
			<td class="text-left">
				<c:forEach items="${book.authors}" var ="author" varStatus="loop">
					${author.lastname } ${author.firstname}<c:if test="${!loop.last}"><br /></c:if>
				</c:forEach>
			</td>
			<td  class="text-center">
				<c:forEach items="${book.authors}" var ="author" varStatus="loop">
					${author.country}<c:if test="${!loop.last}"><br /></c:if>
				</c:forEach>
			</td>
			<td class="text-left">${book.price }</td>
			<td class="text-center">${book.availability}</td>
			<td class="text-center"><a href="#" id="modif"></a></td>
			<td class="text-center"><a href="#" id="supp"></a></td>
			
		</tr>
		</c:forEach>


</tbody>
</table>
  

