<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-wrapper">
	<table class="fl-table">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Login</th>
				<th>Mail</th>
				<th>Adresse de livraison</th>
				<th>Bloqué</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="client" items="${ catalog }">
				<tr>
					<td>${client.id_client}</td>
					<td type="left">${client.nom}</td>
					<td>${client.prenom}</td>
					<td type="left">${client.login}</td>
					<td>
						<a href="bibliotheque?id=edit&code=${book.id}"><i class="fa fa-edit fa-2x"></i></a>
						<a href="bibliotheque?id=delete&code=${book.id}"><i class="fa fa-trash fa-2x"></i></a>
					</td>
				</tr>
	        </c:forEach>
		</tbody>
	</table>
</div>