package util;

import java.util.EventListener;

/**
 * Spécification de la fonctionnalité d'observabilité globale des modèles.
 * Cette fonctionnalité est déléguée à des écouteurs de type L, typiquement
 *  ChangeListener ou PropertyChangeListener (global).
 *  
 * @inv <pre>
 *     getModelObservers() != null </pre>
 */
public interface GloballyObservable<L extends EventListener> {
    
    // REQUETES

    /**
     * Les observateurs de ce modèle sous forme de séquence.
     */
    L[] getModelObservers();

    // COMMANDES

    /**
     * Ajoute un nouvel observateur à ce modèle.
     * @pre <pre>
     *     observer != null </pre>
     * @post <pre>
     *     Let oldObs ::= old getModelObservers()
     *         obs    ::= getModelObservers()
     *     |obs| == |oldObs| + 1
     *     exists k, 0 <= k < |obs| : obs[k] == observer
     *     forall i, 0 <= i < |obs|, i != k :
     *         exists j, 0 <= j < |oldObs| : obs[i] == oldObs[j] </pre>
     */
    void addModelObserver(L observer);

    /**
     * Retire un observateur de ce modèle.
     * @pre <pre>
     *     observer != null </pre>
     * @post <pre>
     *     Let oldObs ::= old getModelObservers()
     *         obs    ::= getModelObservers()
     *     exists k, 0 <= k < |oldObs| : oldObs[k] == observer
     *         ==> |obs| == |oldObs| - 1
     *             |{i : obs[i] == observer}| == |{i : oldObs[i] == observer}|-1
     *             forall i, 0 <= i < |obs| :
     *                 exists j, 0 <= j < |oldObs| : obs[i] == oldObs[j]
     *     forall i, 0 <= i < |oldObs| : oldObs[i] != observer
     *         ==> |obs| == |oldObs|
     *             forall i, 0 <= i < |obs| :
     *                 exists j, 0 <= j < |oldObs| : obs[i] == oldObs[j] </pre>
     */
    void removeModelObserver(L observer);
}
