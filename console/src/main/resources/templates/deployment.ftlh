apiVersion: apps/v1
kind: Deployment
metadata:
  name: ${deploymentName}
  namespace: ${namespace}
spec:
  selector:
    matchLabels:
      app: ${deploymentName}
  replicas: 1
  template:
    metadata:
      labels:
        app: ${deploymentName}
    spec:
      containers:
        - name: ${deploymentName}
          image: ${imageName}
          ports:
            - containerPort: 8080