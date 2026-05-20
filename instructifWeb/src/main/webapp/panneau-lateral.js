class PanneauLateral extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <aside id="cont_infos_laterales">
            <div style="display:flex; gap:5px; align-items: center;">
                <img src="icone-livre.png" style="width: 45px; height: 50px; object-fit: contain;" alt="Livre" />
                
                <div style="display: flex; flex-direction: column; align-items: flex-start;">
                    <div class="Logo tres-grand" style="margin-bottom:0px">INSTRUCT'IF</div>
                    <h2 id="espace" class="texte-description moyen" style="margin-top:0px">Espace élève</h2>
                </div>
            </div>

            <div class="trait"></div>

            <div class="cont-central" style="min-height: 65vh;">
                <div onclick="nouvelleDemande(this)" class="bloc liste-demande"> + Nouvelle demande</div>
                <div onclick="mesDemandes(this)" class="bloc liste-demande"> ≡ Mes demandes</div>
            </div>

            <div class="trait"></div>
            
            <div class="bloc gris margin-bot">
                <div style="display:flex; gap:5px; align-items: center;">
                    <img src="icone-user.png" style="width: 45px; height: 50px; object-fit: contain;" alt="Utilisateur" />

                    <div style="display: flex; flex-direction: column; justify-content: center; align-items: flex-start;">
                        <div id="prenom-nom">Lucas Martin</div> 
                        <div id="classe" class="texte-description petit">4ème</div>
                    </div>
                </div>
            </div>

            <div onclick="deconnection()" class="bloc deconnection">
                <div style="display:flex; gap:5px; align-items: center;">
                    <img src="sortie.png" style="width: 30px; height: 40px; object-fit: contain;" alt="Déconnexion" />

                    <div class="texte-description moyen">Se déconnecter</div>
                </div>
            </div>

        </aside>
        `;


    }

}

customElements.define('panneau-lateral', PanneauLateral);

function mesDemandes(element) {
    document.querySelectorAll(".liste-demande").forEach(t => t.classList.remove("is-active"));
    window.location.href = "historique-demande.html";
    element.classList.toggle('is-active');

}

function nouvelleDemande(element) {
    document.querySelectorAll(".liste-demande").forEach(t => t.classList.remove("is-active"));
    element.classList.toggle('is-active');
    console.log("bonjour")
    window.location.href = "choix-matiere.html";
    


}

function deconnection() {
    window.location.href = "connexion.html";

}