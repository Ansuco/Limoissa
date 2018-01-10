<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
    pageEncoding="UTF-8"
 %>
 
<jsp:include page="fragments/head.jsp" />

<body>

<div class="table-title">
    <h3>Librairie Limoissa</h3>
</div>
<div id="content">
    <div id="maincontent">
        <section id="contact">
            <form action="<c:url value='/add'/>" method="post"  autocomplete="on">
                <fieldset class="red">
                    <legend>Infos obligatoires</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="lastname" class="iconic atelier" > Nom Auteur <span class="required">*</span></label>
                                <input type="text" name="lastname" id="lastname" tabindex="1"  required="required" placeholder=""  />
                            </td>                                       
                            <td>
                                <label for="firstname" class="iconic tete" > Prénom Auteur <span class="required">*</span></label>                              
                                <input type="text" name="firstname" id="firstname"  required="required" placeholder=""  />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="country" class="iconic ou" > Pays Auteur <span class="required">*</span></label>                              
                                <input type="text" name="country" id="country"  required="required" placeholder=""  />
                            </td>
                        </tr>
                        <tr>										
                            <td>
                                <label for="availability" class="iconic arch" > Disponibilité <span class="required">*</span></label>
                                <select class="blank" name="availability" id="archive" tabindex="2">
                                    <option value="1">Oui</option>
                                    <option value="0" selected="selected">Non</option>
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
                <input type="submit" value=" ★  Envoyer !" /> 

            </form>
        </section>
    </div>
</div>
</body>