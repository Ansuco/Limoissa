<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

	<c:choose>



		<c:when test="${actionName == 'books'}">
			<jsp:include page="listbooks.jsp" />
		</c:when>
		<c:when test="${actionName == 'add'}">
			<jsp:include page="ajouter.jsp" />
		</c:when>
		<c:when test="${actionName == 'addauthor'}">
			<jsp:include page="ajouter.jsp" />
		</c:when> 




		<c:otherwise>
			<section>
				<article>Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Morbi laoreet lacinia leo vel lacinia. Aliquam
					porttitor at felis et finibus. Mauris velit quam, porta nec
					fermentum sit amet, pretium sit amet ipsum. Nullam ut porttitor
					urna. Quisque sit amet fringilla lacus. Fusce accumsan odio id nisi
					dapibus, at porta tellus rhoncus.</article>
			</section>
		</c:otherwise>
	</c:choose>
