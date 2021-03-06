/*-
 * $Log: AbstractCreateAPIAction.java,v $
 * Revision 1.6  2005/12/04 22:17:21  madcook
 * New code formatting settings and all 3.0.0 resources to date added.
 *
 * Revision 1.5  2005/12/04 20:26:26  madcook
 * Version 3.0.0 work started.
 *
 * Revision 1.4  2005/11/21 13:04:32  madcook
 * Plugin version 3.0.0 work started and made code to comply with all java 5 
 * settings.
 *
 * Revision 1.3  2005/04/01 11:27:12  harpechr
 * Reference to a static string changed to an interface.
 *
 * Revision 1.2  2005/03/25 09:19:59  harpechr
 * Version 2.0.0 code that has implemented the new java 1.5 features.
 *
 * Revision 1.1  2005/02/28 07:38:25  harpechr
 * Refactored actions so that they are in view and type spesific packages.
 *
 * Revision 1.4  2005/02/09 14:01:29  harpechr
 * Version 1.0.5 work started.
 *
 * Revision 1.3  2005/01/24 12:34:53  harpechr
 * Version 1.0.4 work started.
 *
 * Revision 1.2  2005/01/11 14:02:00  harpechr
 * Changed version number from 1.0.2 to 1.0.3.
 *
 * Revision 1.1  2005/01/09 10:46:54  harpechr
 * Renamed classes that were abstract by prefixing the class name with 
 * 'Abstract'.
 *
 * Revision 1.1  2005/01/07 12:37:48  harpechr
 * Version 1.0.2 code. First CVS commit!
 *
 */

package org.cah.eclipse.plugins.dctm.dql.actions.connection.api;

import org.cah.eclipse.plugins.dctm.dql.IDCTMPlugin;
import org.cah.eclipse.plugins.dctm.dql.actions.AbstractBaseAction;
import org.cah.eclipse.plugins.dctm.dql.editors.APIEditor;
import org.cah.eclipse.plugins.dctm.dql.views.MessageView;
import org.eclipse.ui.IEditorPart;


/**
 * <H4>Abstract create API statements class.</H4>
 * <DL>
 * <DT><B>Copyright : </B>
 * <DD>(c) 2005 Christopher Harper</DD>
 * </DT>
 * <DT><B>Created : </B>
 * <DD>Jan 2, 2005 10:54:09 PM.</DD>
 * </DT>
 * </DL>
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * </p>
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the <a
 * href="http://www.gnu.org/licenses/gpl.html">GNU General Public License </a>
 * for more details.
 * </p>
 * 
 * @author Christopher Harper account : HARPECHR
 * @version 3.0.0
 * @since 1.0.2
 */
public abstract class AbstractCreateAPIAction
												extends
													AbstractBaseAction
{

	/**
	 * Sole constructor.
	 * <DL>
	 * <DT><B>Created : </B>
	 * <DD>Jan 2, 2005 10:54:09 PM</DD>
	 * </DT>
	 * <DT><B>Author : </B>
	 * <DD>Christopher Harper account : HARPECHR</DD>
	 * </DT>
	 * </DL>
	 * 
	 * @since 1.0
	 */
	public AbstractCreateAPIAction()
	{

		super();
	}

	/**
	 * Create the create API statement.
	 * <DL>
	 * <DT><B>Created : </B>
	 * <DD>Jan 2, 2005 7:29:08 PM</DD>
	 * </DT>
	 * <DT><B>Author : </B>
	 * <DD>Christopher Harper account : HARPECHR</DD>
	 * </DT>
	 * </DL>
	 * 
	 * @since 1.0
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run()
	{

		IEditorPart editor = null;
		if(getView() != null)
		{
			editor = getView().getSite().getWorkbenchWindow().getActivePage()
				.getActiveEditor();
		}
		APIEditor apiEditor = null;
		if((editor != null) && (editor instanceof APIEditor))
		{
			apiEditor = (APIEditor) editor;
		}
		if(apiEditor == null)
		{
			MessageView.getInstance().addMessage("No active API editor"); //$NON-NLS-1$
			return;
		}
		apiEditor.setText(apiEditor.getText() + IDCTMPlugin.NEWLINE
			+ getCreateAPI());
	}

	/**
	 * Create the create api statements.
	 * <DL>
	 * <DT><B>Created : </B>
	 * <DD>Jan 2, 2005 10:57:16 PM</DD>
	 * </DT>
	 * <DT><B>Author : </B>
	 * <DD>Christopher Harper account : HARPECHR</DD>
	 * </DT>
	 * </DL>
	 * 
	 * @since 1.0
	 * @return the statements.
	 */
	protected abstract String getCreateAPI();
}
