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
            <h1> Ajouter un nouveau livre</h1>

            <form action="#" method="post"  autocomplete="on" enctype="multipart/form-data">
                <fieldset class="red">
                    <legend>Ajouter un auteur</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="nom" class="iconic atelier" > Nom <span class="required">*</span></label>
                                <input type="text" name="nom" id="nom" tabindex="1"  required="required" placeholder=""  />
                            </td>                                       
                            <td>
                                <label for="prenom" class="iconic tete" > Prénom <span class="required">*</span></label>                              
                                <input type="text" name="prenom" id="prenom"  required="required" placeholder=""  />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="pays" class="iconic ou" > Pays <span class="required">*</span></label>                              
                                <input type="text" name="pays" id="pays"  required="required" placeholder=""  />
                            </td>
                        </tr>       

                    </table>
                </fieldset> 
                <input class ="firstb" type="submit" value=" ★  Envoyer !" /> 
            </form>


            <form action="#" method="post"  autocomplete="on" enctype="multipart/form-data">
                <fieldset class="red">
                    <legend>Infos obligatoires</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="auteur" class="iconic atelier" > Auteur <span class="required">*</span></label>
                                <select class="blank" name="archive" id="archive" tabindex="2">
                                    <option value="1">Auteur1</option>
                                    <option value="1">Auteur1</option>
                                    <option value="1">Auteur1</option>
                                    <option value="1">Auteur1</option>
                                    <option value="0" selected="selected">Auteur2</option>
                                </select>
                            </td>										
                            <td>
                                <label for="archive" class="iconic arch" > Disponibilité <span class="required">*</span></label>
                                <select class="blank" name="archive" id="archive" tabindex="2">
                                    <option value="1">Oui</option>
                                    <option value="0" selected="selected">Non</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="titre" class="iconic tete" > Titre <span class="required">*</span></label>								
                                <input type="text" name="titre" id="titre"  required="required" placeholder=""  />
                            </td>
                            <td>
                                <label for="tarif" class="iconic prix" > Tarif <span class="required">*</span></label>                                                      
                                <input type="text" name="tarif" id="tarif"  required="required" placeholder=""  />
                            </td>
                        </tr>		

                    </table>
                </fieldset>	
                <fieldset>
                    <legend> Infos supplementaires</legend>
                    <table>
                        <tr>
                            <td>
                                <label for="message" class="iconic comment"> Overview </label> 
                                <textarea id="message" name="editor1" placeholder="<p>respectez le format</p>"  ></textarea>
                            </td>
                        </tr>
                    </table>	
                </fieldset>			
                <p class="indication"> Tous les champs avec <span class="required">*</span> sont obligatoires</p>
                <input type="button" onclick="location.href='limoissa.html'" value=" ★  Annuler !" />       
                <input type="submit" value=" ★  Envoyer !" /> 

            </form>
        </section>
    </div>
</div>
</body>