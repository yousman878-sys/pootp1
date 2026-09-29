package util;

import java.beans.PropertyChangeListener;

/**
 * Spécification de la fonctionnalité d'observabilité des propriétés des
 *  modèles (vus comme des beans).
 * Cette fonctionnalité est déléguée à des PropertyChangeListener.
 *  
 * @inv <pre>
 *     forall s in String, !s.isEmpty() : getPropertyObservers(s) != null </pre>
 */
public interface LocallyObservable {
    
    // REQUETES

    /**
     * La séquence des observateurs de la propriété p de ce modèle.
     * @pre <pre>
     *     p != null && !p.isEmpty() </pre>
     */
    PropertyChangeListener[] getPropertyObservers(String p);

    // COMMANDES

    /**
     * Ajoute à ce modèle un nouvel observateur pour sa propriété p.
     * @pre <pre>
     *     p != null && !p.isEmpty()
     *     observer != null </pre>
     * @post <pre>
     *     Let oldObs ::= old getPropertyObservers(p)
     *         obs    ::= getPropertyObservers(p)
     *     |obs| == |oldObs| + 1
     *     exists k, 0 <= k < |obs| : obs[k] == observer
     *     forall i, 0 <= i < |obs|, i != k :
     *         exists j, 0 <= j < |oldObs| : obs[i] == oldObs[j] </pre>
     */
    void addPropertyObserver(String p, PropertyChangeListener observer);

    /**
     * Retire de ce modèle un observateur pour sa propriété p.
     * @pre <pre>
     *     p != null && !p.isEmpty()
     *     observer != null </pre>
     * @post <pre>
     *     Let oldObs ::= old getPropertyObservers(p)
     *         obs    ::= getPropertyObservers(p)
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
    void removePropertyObserver(String p, PropertyChangeListener observer);
}
