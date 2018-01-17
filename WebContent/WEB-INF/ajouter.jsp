<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="UTF-8"
 %>
 



<div class="table-title">
    <h3>Librairie Limoissa</h3>
</div>
<div id="content">
    <div id="maincontent">
        <section id="contact">
            <h1> Ajouter un nouveau livre</h1>

            <form action="<c:url value='/addauthor'/>" method="post"  autocomplete="on" id="form-author">
                <fieldset class="red">
                    <legend>Ajouter un auteur</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="lastname" class="iconic atelier" > Nom <span class="required">*</span></label>
                                <input type="text" name="lastname" id="lastname" tabindex="1"  required="required" placeholder=""  />
                            </td>                                       
                            <td>
                                <label for="firstname" class="iconic tete" > Prénom <span class="required">*</span></label>                              
                                <input type="text" name="firstname" id="firstname"  required="required" placeholder=""  />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="country" class="iconic ou" > Pays <span class="required">*</span></label>                              
                                <input type="text" name="country" id="country"  required="required" placeholder=""  />
                            </td>
                            <td>
                            	<input class ="firstb" type="submit" value=" ★  Envoyer !" form="form-author" /> 
                            </td>
                        </tr>       

                    </table>
                </fieldset> 
                
            </form>


            <form action="<c:url value='/add'/>" method="post"  autocomplete="on" id="form-book">
                <fieldset class="red">
                    <legend>Infos obligatoires</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="authors" class="iconic atelier" > Auteur <span class="required">*</span></label>
                                <select multiple="multiple" class="blank" name="authors" id="authors" tabindex="2">
                                	<c:forEach items="${authors}" var="author">
										<option value="${author.id} ${author.firstname} ${author.lastname} ${author.country}">
											${author.firstname} ${author.lastname}
										</option>
									</c:forEach> 
                                </select>
                            </td>										
                            <td>
                                <label for="availability" class="iconic arch" > Disponibilité <span class="required">*</span></label>
                                <select class="blank" name="availability" id="archive" tabindex="2">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="title" class="iconic tete" > Titre <span class="required">*</span></label>								
                                <input type="text" name="title" id="title"  required="required" placeholder=""  />
                            </td>
                            <td>
                                <label for="price" class="iconic prix" > Tarif <span class="required">*</span></label>                                                      
                                <input type="text" name="price" id="price"  required="required" placeholder=""  />
                            </td>
                        </tr>		

                    </table>
                </fieldset>	
                <fieldset>
                    <legend> Infos supplementaires</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="overview" class="iconic comment"> Overview </label> 
                                <textarea id="overview" name="overview" placeholder="<p>respectez le format</p>"  ></textarea>
                            </td>
                        </tr>
                    </table>	
                </fieldset>			
                <p class="indication"> Tous les champs avec <span class="required">*</span> sont obligatoires</p>
                <input type="button" onclick="location.href='limoissa.html'" value=" ★  Annuler !" />  <a href="<c:url value='/books'/>" class="nc">Annuler</a>     
                <input type="submit" value=" ★  Envoyer !" form="form-book" /> 

            </form>
        </section>
    </div>
</div>
