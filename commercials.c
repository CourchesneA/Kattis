#include <stdlib.h>
#include <stdio.h>

int main(){
    int n, p, i, j;
    scanf("%d%d", &n, &p);
    int* listeners = (int*) malloc(sizeof(int)*n);
    for(i=0; i<n; i++){
        scanf("%d",&listeners[i]);
        listeners[i]-=p;
    }
    int maxProfit=0, profit=0;
    for(int i=0; i<n; i++,profit=0){
        if(listeners[i] < 0 )
            continue;
        for(j=i; j<n; j++){
            profit+=listeners[j];
            if(listeners[j] < 0)
                continue;
            if(profit > maxProfit)
                maxProfit = profit;
        }
    }
    printf("%d",maxProfit);
    free(listeners);
    return 0;
}
