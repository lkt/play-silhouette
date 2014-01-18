/**
 * Original work: SecureSocial (https://github.com/jaliss/securesocial)
 * Copyright 2013 Jorge Aliss (jaliss at gmail dot com) - twitter: @jaliss
 *
 * Derivative work: Silhouette (https://github.com/mohiva/play-silhouette)
 * Modifications Copyright 2014 Mohiva Organisation (license at mohiva dot com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mohiva.play.silhouette.core

import play.api.mvc.{Session, RequestHeader}

/**
 * A trait to model Silhouette events
 */
sealed trait Event { def user: Identity }

/**
 * The event fired when a users logs in
 * @param user
 */
case class LoginEvent(user: Identity) extends Event

/**
 * The event fired when a user logs out
 * @param user
 */
case class LogoutEvent(user: Identity) extends Event

/**
 * The event fired when a user sings up with the Username and Password Provider
 * @param user
 */
case class SignUpEvent(user: Identity) extends Event

/**
 * The event fired when a user changes his password
 * @param user
 */
case class PasswordChangeEvent(user: Identity) extends Event

/**
 * The event fired when a user completes a password reset
 * @param user
 */
case class PasswordResetEvent(user: Identity) extends Event

/**
 * The event listener interface
 */
abstract class EventListener {

  /**
   * The method that gets called when an event occurs.
   *
   * @param event the event type
   * @param request the current request
   * @param session the current session (if you need to manipulate it don't use the one in request.session)
   * @return can return an optional Session object.
   */
  def onEvent(event: Event, request: RequestHeader, session: Session): Option[Session]
}