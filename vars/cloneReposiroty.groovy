def Clone(String branch,String cred,String repo){ 
git branch: "${branch}", credentialsId: "${cred}", url: "${repo}"
}


