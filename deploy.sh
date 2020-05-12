#https://github.com/spring-cloud/spring-cloud-stream-app-starters



#    _    _   _ ____ ___ ____  _     _____ 
#   / \  | \ | / ___|_ _| __ )| |   | ____|
#  / _ \ |  \| \___ \| ||  _ \| |   |  _|  
# / ___ \| |\  |___) | || |_) | |___| |___ 
#/_/   \_\_| \_|____/___|____/|_____|_____|
#     
#https://github.com/rocko83/012-iac-k8s
ansible-playbook -i inventories/inventory --limit=192.168.56.150 -u operador -b common.yml

# _   _ _____ _     __  __ 
#| | | | ____| |   |  \/  |
#| |_| |  _| | |   | |\/| |
#|  _  | |___| |___| |  | |
#|_| |_|_____|_____|_|  |_|
#   
cat << EOF > deploy.sh
alias k=kubectl
alias ks="k -n scdf"
export KUBECONFIG=/root/.kube/config
snap install helm --classic
k create ns scdf
cd charts
git clone https://github.com/helm/charts.git
helm dependency update  stable/spring-cloud-data-flow
helm install scdf  --namespace scdf --set kafka.enabled=true,rabbitmq.enabled=false  stable/spring-cloud-data-flow
watch kubectl -n scdf get all 

EOF

sh deploy.sh

helm list
helm delete scdf
helm delete --purge scdf
# __  __ ___ _   _ ___ _  ___   _ ____  _____ 
#|  \/  |_ _| \ | |_ _| |/ / | | | __ )| ____|
#| |\/| || ||  \| || || ' /| | | |  _ \|  _|  
#| |  | || || |\  || || . \| |_| | |_) | |___ 
#|_|  |_|___|_| \_|___|_|\_\\___/|____/|_____|
#     
minikube start --driver=none
ks port-forward pod/scdf-data-flow-server-6c8bd4f467-4qn8n --address 0.0.0.0 8080:8080
ks port-forward pod/$(kubectl -n scdf get pods | grep server | awk '{print $1}') --address 0.0.0.0 8080:8080
#    _    ____  ____  
#   / \  |  _ \|  _ \ 
#  / _ \ | |_) | |_) |
# / ___ \|  __/|  __/ 
#/_/   \_\_|   |_|    
#    
docker://registry.hub.docker.com/clusterlab/scdf-sink-log:0.3
docker://registry.hub.docker.com/clusterlab/scdf-source-http:0.3


# ____   ____ ____  _____    ____  _   _ _____ _     _     
#/ ___| / ___|  _ \|  ___|  / ___|| | | | ____| |   | |    
#\___ \| |   | | | | |_ ____\___ \| |_| |  _| | |   | |    
# ___) | |___| |_| |  _|_____|__) |  _  | |___| |___| |___ 
#|____/ \____|____/|_|      |____/|_| |_|_____|_____|_____|
#    
dataflow config server http://template:8080


app register scdf-sink-log --uri docker://registry.hub.docker.com/clusterlab/scdf-sink-log:0.5 --type sink
app register scdf-source-http --uri docker://registry.hub.docker.com/clusterlab/scdf-source-http:0.5 --type source
stream create --name scdf --definition "scdf-source-http | scdf-sink-log"
stream deploy --name scdf

